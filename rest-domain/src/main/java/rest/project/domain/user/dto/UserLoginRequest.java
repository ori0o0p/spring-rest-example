package rest.project.domain.user.dto;

public record UserLoginRequest(
        String email,
        String password
) {
}
