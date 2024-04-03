package rest.project.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.user.model.User;
import rest.project.domain.user.port.FindUserPort;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurrentUserImpl implements CurrentUser {
    private final FindUserPort findUserPort;

    @Override
    public User execute() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return findUserPort.findByEmail(email);
    }

}
