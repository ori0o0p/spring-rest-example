package rest.project.domain.token.usecase;

import rest.project.domain.user.dto.UserLoginRequest;
import rest.project.domain.user.dto.UserLoginResponse;

public interface CreateTokenUseCase {
    UserLoginResponse execute(UserLoginRequest request);

}
