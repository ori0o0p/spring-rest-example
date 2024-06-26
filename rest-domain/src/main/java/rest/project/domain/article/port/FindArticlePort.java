package rest.project.domain.article.port;

import rest.project.domain.article.model.Article;

import java.util.List;
import java.util.Optional;

public interface FindArticlePort {

    Article findById(Long id);
    List<Article> findAll();
    List<Article> search(String text);
    Article getReferenceById(Long id);

}
