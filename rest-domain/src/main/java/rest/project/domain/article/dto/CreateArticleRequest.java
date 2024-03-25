package rest.project.domain.article.dto;

import rest.project.domain.article.model.Article;

public record CreateArticleRequest(
        String title,
        String content
) {

    public static Article toArticleEntity(CreateArticleRequest request) {
        return Article.builder()
                .title(request.title)
                .content(request.content)
                .build();
    }

}
