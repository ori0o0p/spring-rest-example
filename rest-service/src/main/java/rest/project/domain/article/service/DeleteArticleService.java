package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.model.Article;
import rest.project.domain.article.port.DeleteArticlePort;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.article.usecase.DeleteArticleUseCase;
import rest.project.domain.user.service.CurrentUser;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteArticleService implements DeleteArticleUseCase {
    private final DeleteArticlePort deleteArticlePort;
    private final FindArticlePort findArticlePort;
    private final CurrentUser currentUser;

    @Override
    public void deleteById(Long id) {
        Article article = findArticlePort.findById(id);

        if (currentUser.execute().getId() != article.getUser().getId()) {
            throw new RuntimeException("user is not owner of article");
        } else {
            deleteArticlePort.deleteById(id);
        }
    }

}
