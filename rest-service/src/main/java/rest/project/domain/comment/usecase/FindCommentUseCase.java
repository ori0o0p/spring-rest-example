package rest.project.domain.comment.usecase;

import rest.project.domain.comment.model.Comment;

import java.util.List;

public interface FindCommentUseCase {
    List<Comment> findAllByArticle(Long articleId);

}
