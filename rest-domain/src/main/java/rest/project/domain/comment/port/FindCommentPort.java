package rest.project.domain.comment.port;

import rest.project.domain.comment.model.Comment;

import java.util.List;

public interface FindCommentPort {

    List<Comment> findAllByArticle(Long articleId);
    Comment findById(Long id);

}
