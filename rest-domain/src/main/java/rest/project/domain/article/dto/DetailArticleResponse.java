package rest.project.domain.article.dto;

import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;
import rest.project.domain.article.model.Article;
import rest.project.domain.comment.dto.CommentResponse;
import rest.project.domain.like.dto.LikeResponse;
import rest.project.domain.tag.dto.TagResponse;
import rest.project.domain.tag.model.tagmap.TagMap;
import rest.project.domain.user.dto.UserResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Relation(collectionRelation = "data")
public record DetailArticleResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<CommentResponse> comments,
        UserResponse writer,
        Set<TagResponse> tags,
        LikeResponse likeInfo
        /* other.. */
) {

    public static DetailArticleResponse from(Article article) {
        return DetailArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .comments(article.getComments().stream().map(CommentResponse::from).toList())
                .writer(UserResponse.from(article.getUser()))
                .tags(article.getTagMaps().stream().map(TagMap::getTag).map(TagResponse::from).collect(Collectors.toUnmodifiableSet()))
                .likeInfo(LikeResponse.of(article.getLikes()))
                .build();
    }

}
