package rest.project.domain.like.dto;

public record IsLikeResponse(
        boolean isLike
) {

    public static IsLikeResponse of(boolean isLike) {
        return new IsLikeResponse(isLike);
    }

}
