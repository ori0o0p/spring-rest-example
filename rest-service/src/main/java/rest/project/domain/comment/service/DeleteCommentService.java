package rest.project.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.comment.port.DeleteCommentPort;
import rest.project.domain.comment.port.FindCommentPort;
import rest.project.domain.comment.usecase.DeleteCommentUseCase;
import rest.project.domain.user.model.User;
import rest.project.domain.user.service.CurrentUser;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteCommentService implements DeleteCommentUseCase {
    private final DeleteCommentPort deleteCommentPort;
    private final FindCommentPort findCommentPort;
    private final CurrentUser currentUser;

    @Override
    public void deleteById(Long id) {
        User user = currentUser.execute();
        Comment comment = findCommentPort.findById(id);

        if (user.getId() != comment.getUser().getId()) {
            throw new RuntimeException("user is not owner of comment");
        } else {
            deleteCommentPort.deleteById(id);
        }
    }

}
