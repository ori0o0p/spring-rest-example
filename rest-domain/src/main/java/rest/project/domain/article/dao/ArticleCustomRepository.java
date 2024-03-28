package rest.project.domain.article.dao;

import rest.project.domain.article.model.Article;
import java.util.List;

public interface ArticleCustomRepository {
    List<Article> search(String text);

}
