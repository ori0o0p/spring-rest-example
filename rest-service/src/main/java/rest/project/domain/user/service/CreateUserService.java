package rest.project.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.user.dto.CreateUserRequest;
import rest.project.domain.user.port.SaveUserPort;
import rest.project.domain.user.usecase.CreateUserUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final SaveUserPort saveUserPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(CreateUserRequest request) {
        saveUserPort.save(
                CreateUserRequest.toUserEntity(
                        request.name(),
                        request.email(),
                        passwordEncoder.encode(request.password())
                )
        );
    }

}
