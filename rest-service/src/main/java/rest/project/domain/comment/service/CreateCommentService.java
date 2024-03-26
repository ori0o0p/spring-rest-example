package rest.project.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.project.domain.article.model.Article;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.comment.dto.CreateCommentRequest;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.comment.port.SaveCommentPort;
import rest.project.domain.comment.usecase.CreateCommentUseCase;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CreateCommentUseCase {
    private final SaveCommentPort saveCommentPort;
    private final FindArticlePort findArticlePort;

    @Override
    public void create(CreateCommentRequest request, Long articleId) {
        Article article = findArticlePort.findById(articleId);

        saveCommentPort.save(
                Comment.builder()
                        .content(request.content())
                        .article(article)
                        .build()
        );
    }

}
