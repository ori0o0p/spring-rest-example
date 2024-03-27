package rest.project.domain.user.dto;

import rest.project.domain.user.model.User;

public record CreateUserRequest(
        String name,
        String email,
        String password
) {

    public static User toUserEntity(String name, String email, String password) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

}
