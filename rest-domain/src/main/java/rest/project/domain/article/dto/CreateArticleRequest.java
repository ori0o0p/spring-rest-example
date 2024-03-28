package rest.project.domain.article.dto;

import rest.project.domain.article.model.Article;
import rest.project.domain.user.model.User;

public record CreateArticleRequest(
        String title,
        String content
) {

    public static Article toArticleEntity(CreateArticleRequest request, User user) {
        return Article.builder()
                .title(request.title)
                .content(request.content)
                .user(user)
                .build();
    }

}
