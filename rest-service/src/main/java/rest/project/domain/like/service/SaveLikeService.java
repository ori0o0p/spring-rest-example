package rest.project.domain.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.project.domain.article.model.Article;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.like.model.Like;
import rest.project.domain.like.port.SaveLikePort;
import rest.project.domain.like.usecase.SaveLikeUseCase;
import rest.project.domain.user.model.User;
import rest.project.domain.user.service.CurrentUser;

@Service
@RequiredArgsConstructor
public class SaveLikeService implements SaveLikeUseCase {
    private final FindArticlePort findArticlePort;
    private final SaveLikePort saveLikePort;
    private final CurrentUser currentUser;

    @Override
    public void save(Long articleId) {
        Article article = findArticlePort.findById(articleId);
        User user = currentUser.execute();

        saveLikePort.save(
                Like.builder()
                        .article(article)
                        .user(user)
                        .build()
        );
    }

}
