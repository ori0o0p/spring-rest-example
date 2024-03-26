package rest.project.domain.comment.usecase;

import rest.project.domain.comment.dto.CreateCommentRequest;

public interface CreateCommentUseCase {
    void create(CreateCommentRequest request, Long articleId);

}
