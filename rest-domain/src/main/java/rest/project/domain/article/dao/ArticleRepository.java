package rest.project.domain.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.project.domain.article.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {
}
