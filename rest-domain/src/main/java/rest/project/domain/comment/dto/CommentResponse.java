package rest.project.domain.comment.dto;

import lombok.Builder;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.user.dto.UserResponse;

import java.time.LocalDateTime;

@Builder
public record CommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        UserResponse writer
) {

    public static CommentResponse from(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .writer(UserResponse.from(comment.getUser()))
                .build();
    }

}
