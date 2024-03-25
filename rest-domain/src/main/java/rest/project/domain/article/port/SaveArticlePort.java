package rest.project.domain.article.port;

import rest.project.domain.article.model.Article;

public interface SaveArticlePort {
    Article save(Article article);

}
