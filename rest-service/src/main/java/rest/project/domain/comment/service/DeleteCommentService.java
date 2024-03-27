package rest.project.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.comment.port.DeleteCommentPort;
import rest.project.domain.comment.usecase.DeleteCommentUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteCommentService implements DeleteCommentUseCase {
    private final DeleteCommentPort deleteCommentPort;

    @Override
    public void deleteById(Long id) {
        deleteCommentPort.deleteById(id);
    }

}