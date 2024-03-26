package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.dto.CreateArticleRequest;
import rest.project.domain.article.port.SaveArticlePort;
import rest.project.domain.article.usecase.CreateArticleUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateArticleService implements CreateArticleUseCase {
    private final SaveArticlePort saveArticlePort;

    @Override
    public void create(CreateArticleRequest request) {
        saveArticlePort.save(
                CreateArticleRequest.toArticleEntity(request)
        );
    }

}
