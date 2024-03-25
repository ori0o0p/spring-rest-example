package rest.project.domain.article.usecase;

import rest.project.domain.article.model.Article;

import java.util.List;

public interface FindArticleUseCase {
    Article findById(Long id);
    List<Article> findAll();
    List<Article> findAllByTextContaining(String text);

}
