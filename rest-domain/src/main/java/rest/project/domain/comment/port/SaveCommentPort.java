package rest.project.domain.comment.port;

import rest.project.domain.comment.model.Comment;

public interface SaveCommentPort {
    Comment save(Comment comment);

}
