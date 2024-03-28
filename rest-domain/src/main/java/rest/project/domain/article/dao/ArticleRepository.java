package rest.project.domain.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rest.project.domain.article.model.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {

}
