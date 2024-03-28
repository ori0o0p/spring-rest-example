package rest.project.domain.user.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.project.domain.token.usecase.CreateTokenUseCase;
import rest.project.domain.user.dto.CreateUserRequest;
import rest.project.domain.user.dto.UserLoginRequest;
import rest.project.domain.user.dto.UserLoginResponse;
import rest.project.domain.user.usecase.CreateUserUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final CreateTokenUseCase createTokenUseCase;

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody CreateUserRequest request) {
        createUserUseCase.save(request);
    }

    @PostMapping("/auth/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        return createTokenUseCase.execute(request);
    }

}
