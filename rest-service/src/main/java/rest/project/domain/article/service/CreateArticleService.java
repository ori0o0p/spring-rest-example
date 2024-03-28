package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.dto.CreateArticleRequest;
import rest.project.domain.article.port.SaveArticlePort;
import rest.project.domain.article.usecase.CreateArticleUseCase;
import rest.project.domain.user.service.CurrentUser;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateArticleService implements CreateArticleUseCase {
    private final SaveArticlePort saveArticlePort;
    private final CurrentUser currentUser;

    @Override
    public void create(CreateArticleRequest request) {
        saveArticlePort.save(
                CreateArticleRequest.toArticleEntity(request,
                        currentUser.execute()
                )
        );
    }

}
