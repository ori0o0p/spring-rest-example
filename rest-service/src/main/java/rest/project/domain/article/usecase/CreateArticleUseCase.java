package rest.project.domain.article.usecase;

import rest.project.domain.article.dto.CreateArticleRequest;

public interface CreateArticleUseCase {
    void create(CreateArticleRequest request);

}
