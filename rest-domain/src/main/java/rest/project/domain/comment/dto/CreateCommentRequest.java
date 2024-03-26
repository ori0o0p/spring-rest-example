package rest.project.domain.comment.dto;

import rest.project.domain.comment.model.Comment;

public record CreateCommentRequest(
        String content
) {
}
