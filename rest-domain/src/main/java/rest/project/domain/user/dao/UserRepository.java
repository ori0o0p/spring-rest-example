package rest.project.domain.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.project.domain.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

}
