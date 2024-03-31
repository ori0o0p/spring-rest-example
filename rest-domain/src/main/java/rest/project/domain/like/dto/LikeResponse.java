package rest.project.domain.like.dto;

import lombok.Builder;
import rest.project.domain.like.model.Like;

import java.util.List;
import java.util.Set;

@Builder
public record LikeResponse(
        Integer like,
        List<LikeDetail> likeList
) {

    public static LikeResponse of(Set<Like> likes) {
        return LikeResponse.builder()
                .like(likes.size())
                .likeList(likes.stream()
                        .map(LikeDetail::of)
                        .toList())
                .build();
    }

}

@Builder
record LikeDetail(
        Long id,
        Long userId
) {

    public static LikeDetail of(Like like) {
        return LikeDetail.builder()
                .id(like.getId())
                .userId(like.getUser().getId())
                .build();
    }

}