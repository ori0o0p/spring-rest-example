package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.project.domain.article.port.DeleteArticlePort;
import rest.project.domain.article.usecase.DeleteArticleUseCase;

@Service
@RequiredArgsConstructor
public class DeleteArticleService implements DeleteArticleUseCase {
    private final DeleteArticlePort deleteArticlePort;

    @Override
    public void deleteById(Long id) {
        deleteArticlePort.deleteById(id);
    }

}
