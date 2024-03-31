package rest.project.domain.like.usecase;

import rest.project.domain.like.dto.IsLikeResponse;

public interface FindLikeUseCase {
    IsLikeResponse isLike(Long articleId);

}
