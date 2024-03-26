package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.article.usecase.FindArticleUseCase;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.comment.port.FindCommentPort;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindArticleService implements FindArticleUseCase {
    private final FindArticlePort findArticlePort;
    private final FindCommentPort findCommentPort;

    @Override
    public DetailArticleResponse findById(Long id) {
        return DetailArticleResponse.from(
                findArticlePort.findById(id),
                findCommentPort.findAllByArticle(id)
        );
    }

    @Override
    public List<DetailArticleResponse> findAll() {
        return findArticlePort.findAll()
                .stream()
                .map(article -> {
                    List<Comment> comments = findCommentPort.findAllByArticle(article.getId());
                    return DetailArticleResponse.from(article, comments);
                })
                .toList();
    }

    @Override
    public List<DetailArticleResponse> findAllByTextContaining(String text) {
        return findArticlePort.findAllByTextContaining(text)
                .stream()
                .map(article -> {
                    List<Comment> comments = findCommentPort.findAllByArticle(article.getId());
                    return DetailArticleResponse.from(article, comments);
                })
                .toList();
    }

}
