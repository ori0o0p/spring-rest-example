package rest.project.domain.comment.dao;

import org.springframework.data.repository.CrudRepository;
import rest.project.domain.comment.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByArticle_IdOrderByCreatedAtDesc(Long articleId);

}
