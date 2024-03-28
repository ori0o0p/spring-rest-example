package rest.project.domain.user.dto;

import lombok.Builder;
import rest.project.domain.user.model.User;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email
) {

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
