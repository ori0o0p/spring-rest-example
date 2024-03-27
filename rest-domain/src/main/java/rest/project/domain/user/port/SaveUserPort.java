package rest.project.domain.user.port;

import rest.project.domain.user.model.User;

public interface SaveUserPort {
    User save(User user);

}
