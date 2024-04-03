package rest.project.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.model.Article;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.comment.dto.CreateCommentRequest;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.comment.port.SaveCommentPort;
import rest.project.domain.comment.usecase.CreateCommentUseCase;
import rest.project.domain.user.model.User;
import rest.project.domain.user.service.CurrentUser;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateCommentService implements CreateCommentUseCase {
    private final SaveCommentPort saveCommentPort;
    private final FindArticlePort findArticlePort;
    private final CurrentUser currentUser;

    @Override
    public void create(CreateCommentRequest request, Long articleId) {
        Article article = findArticlePort.getReferenceById(articleId);
        User user = currentUser.execute();

        saveCommentPort.save(
                Comment.builder()
                        .content(request.content())
                        .article(article)
                        .user(user)
                        .build()
        );
    }

}
