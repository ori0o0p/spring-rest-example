package rest.project.domain.token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rest.project.Tokenizer;
import rest.project.domain.token.usecase.CreateTokenUseCase;
import rest.project.domain.user.dto.UserLoginRequest;
import rest.project.domain.user.dto.UserLoginResponse;
import rest.project.domain.user.model.User;
import rest.project.domain.user.port.FindUserPort;

@Service
@RequiredArgsConstructor
public class CreateTokenService implements CreateTokenUseCase {
    private final PasswordEncoder passwordEncoder;
    private final FindUserPort findUserPort;
    private final Tokenizer tokenizer;

    @Override
    public UserLoginResponse execute(UserLoginRequest request) {
        User user = findUserPort.findByEmail(request.email());

        if (passwordEncoder.matches(request.password(), user.getPassword())) {
            return UserLoginResponse.builder()
                    .token(tokenizer.generateToken(request.email()))
                    .build();
        } else {
            throw new RuntimeException("password is not correct");
        }
    }

}
