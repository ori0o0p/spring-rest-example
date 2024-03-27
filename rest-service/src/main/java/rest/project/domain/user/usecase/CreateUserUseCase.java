package rest.project.domain.user.usecase;

import rest.project.domain.user.dto.CreateUserRequest;

public interface CreateUserUseCase {
    void save(CreateUserRequest request);

}
