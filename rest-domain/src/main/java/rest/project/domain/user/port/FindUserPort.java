package rest.project.domain.user.port;

import rest.project.domain.user.model.User;

public interface FindUserPort {
    User findByEmail(String email);

}
