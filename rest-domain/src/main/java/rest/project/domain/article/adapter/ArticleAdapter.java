package rest.project.domain.article.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest.project.domain.article.dao.ArticleRepository;
import rest.project.domain.article.model.Article;
import rest.project.domain.article.port.*;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ArticleAdapter implements FindArticlePort, SaveArticlePort, DeleteArticlePort {
    private final ArticleRepository articleRepository;

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("404 Not Found"));
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findAllByTextContaining(String text) {
        return articleRepository.findAllByTextContaining(text);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

}
