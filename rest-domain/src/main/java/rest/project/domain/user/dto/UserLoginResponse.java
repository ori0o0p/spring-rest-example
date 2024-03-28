package rest.project.domain.user.dto;

import lombok.Builder;

@Builder
public record UserLoginResponse(
        String token
) {
}
