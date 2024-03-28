package rest.project.domain.user.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest.project.domain.user.dao.UserRepository;
import rest.project.domain.user.model.User;
import rest.project.domain.user.port.DeleteUserPort;
import rest.project.domain.user.port.FindUserPort;
import rest.project.domain.user.port.SaveUserPort;

@Component
@RequiredArgsConstructor
public class UserAdapter implements SaveUserPort, DeleteUserPort, FindUserPort {
    private final UserRepository userRepository;

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("400 User Exists");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("404 User Not Found"));
    }

}
