package rest.project.domain.article.port;

import rest.project.domain.article.model.Article;

public interface DeleteArticlePort {
    void deleteById(Long id);
    void delete(Article article);

}
