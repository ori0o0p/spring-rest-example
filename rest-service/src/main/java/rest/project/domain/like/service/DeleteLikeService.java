package rest.project.domain.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.project.domain.like.port.DeleteLikePort;
import rest.project.domain.like.usecase.DeleteLikeUseCase;
import rest.project.domain.user.model.User;
import rest.project.domain.user.service.CurrentUser;

@Service
@RequiredArgsConstructor
public class DeleteLikeService implements DeleteLikeUseCase {
    private final DeleteLikePort deleteLikePort;
    private final CurrentUser currentUser;

    @Override
    public void deleteById(Long articleId) {
        User user = currentUser.execute();

        deleteLikePort.deleteByArticleId(
                user.getId(),
                articleId
        );
    }

}
