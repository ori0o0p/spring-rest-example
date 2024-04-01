package rest.project.domain.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.like.dto.IsLikeResponse;
import rest.project.domain.like.port.FindLikePort;
import rest.project.domain.like.usecase.FindLikeUseCase;
import rest.project.domain.user.model.User;
import rest.project.domain.user.service.CurrentUser;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindLikeService implements FindLikeUseCase {
    private final FindLikePort findLikePort;
    private final CurrentUser currentUser;

    @Override
    public IsLikeResponse isLike(Long articleId) {
        User user = currentUser.execute();

        return IsLikeResponse.of(
                findLikePort.isLikeCurrentUser(
                        articleId,
                        user.getId()
                )
        );
    }

}
