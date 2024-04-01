package rest.project.domain.like.dto;

import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "data")
public record IsLikeResponse(
        boolean isLike
) {

    public static IsLikeResponse of(boolean isLike) {
        return new IsLikeResponse(isLike);
    }

}
