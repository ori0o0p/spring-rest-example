package rest.project.domain.user.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.project.domain.user.dto.CreateUserRequest;
import rest.project.domain.user.usecase.CreateUserUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody CreateUserRequest request) {
        createUserUseCase.save(request);
    }

}
