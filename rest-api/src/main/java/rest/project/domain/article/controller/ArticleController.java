package rest.project.domain.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rest.project.domain.article.dto.CreateArticleRequest;
import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.model.ArticleModel;
import rest.project.domain.article.usecase.CreateArticleUseCase;
import rest.project.domain.article.usecase.DeleteArticleUseCase;
import rest.project.domain.article.usecase.FindArticleUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleController {
    private final FindArticleUseCase findArticleUseCase;
    private final CreateArticleUseCase createArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;

    @GetMapping("/{articleId}")
    public ArticleModel findById(@PathVariable Long articleId) {
        ArticleModel articleModel = new ArticleModel(
                findArticleUseCase.findById(articleId)
        );

        Link self = WebMvcLinkBuilder
                .linkTo(ArticleController.class)
                .slash(articleId)
                .withSelfRel();

        articleModel.add(self);

        Link parentLink = WebMvcLinkBuilder
                .linkTo(ArticleController.class)
                .withRel("parent");

        articleModel.add(parentLink);

        return articleModel;
    }

    @GetMapping
    public CollectionModel<DetailArticleResponse> findAll() {
        List<DetailArticleResponse> articleList = findArticleUseCase.findAll();

        Link selfLink = WebMvcLinkBuilder
                .linkTo(ArticleController.class)
                .withSelfRel();

        return CollectionModel.of(
                articleList,
                selfLink
        );
    }

    @PostMapping
    public void create(@RequestBody CreateArticleRequest request) {
        createArticleUseCase.create(request);
    }

    @DeleteMapping("/{articleId}")
    public void delete(@PathVariable Long articleId) {
        deleteArticleUseCase.deleteById(articleId);
    }

}
