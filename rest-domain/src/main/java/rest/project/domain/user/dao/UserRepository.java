package rest.project.domain.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.project.domain.user.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

}
