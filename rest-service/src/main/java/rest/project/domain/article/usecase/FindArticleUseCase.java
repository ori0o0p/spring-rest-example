package rest.project.domain.article.usecase;

import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.model.Article;

import java.util.List;

public interface FindArticleUseCase {
    DetailArticleResponse findById(Long id);
    List<DetailArticleResponse> findAll();
    List<DetailArticleResponse> search(String text);

}
