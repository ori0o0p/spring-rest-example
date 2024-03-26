package rest.project.domain.comment.adapter;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest.project.domain.comment.dao.CommentRepository;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.comment.port.SaveCommentPort;
import rest.project.domain.comment.port.DeleteCommentPort;
import rest.project.domain.comment.port.FindCommentPort;

import java.util.List;

@Component
@RequiredArgsConstructor(access = AccessLevel.MODULE)
public class CommentAdapter implements SaveCommentPort, DeleteCommentPort, FindCommentPort {
    private final CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findAllByArticle(Long articleId) {
        return commentRepository.findAllByArticle_IdOrderByCreatedAtDesc(articleId);
    }

}
