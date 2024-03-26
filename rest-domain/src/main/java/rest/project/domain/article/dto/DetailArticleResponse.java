package rest.project.domain.article.dto;

import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;
import rest.project.domain.article.model.Article;
import rest.project.domain.comment.model.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Relation(collectionRelation = "data")
public record DetailArticleResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<Comment> comments
        /* other.. */
) {

    public static DetailArticleResponse from(Article article, List<Comment> comments) {
        return DetailArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .comments(comments)
                .build();
    }

}
