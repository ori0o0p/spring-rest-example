package rest.project.domain.article.dto;

import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;
import rest.project.domain.article.model.Article;

@Builder
@Relation(collectionRelation = "data")
public record DetailArticleResponse(
        Long id,
        String title,
        String content
        /* other.. */
) {

    public static DetailArticleResponse from(Article article) {
        return DetailArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }

}
