package rest.project.domain.user.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rest.project.domain.user.dto.CreateUserRequest;
import rest.project.domain.user.usecase.CreateUserUseCase;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody CreateUserRequest request) {
        createUserUseCase.save(request);
    }

}
