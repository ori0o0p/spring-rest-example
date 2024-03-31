package rest.project.domain.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.project.domain.article.dto.CreateArticleRequest;
import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.dto.ArticleResponseModel;
import rest.project.domain.article.usecase.CreateArticleUseCase;
import rest.project.domain.article.usecase.DeleteArticleUseCase;
import rest.project.domain.article.usecase.FindArticleUseCase;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleController {
    private final FindArticleUseCase findArticleUseCase;
    private final CreateArticleUseCase createArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;

    @GetMapping("/{articleId}")
    public ArticleResponseModel findById(@PathVariable Long articleId) {
        ArticleResponseModel articleResponseModel = new ArticleResponseModel(
                findArticleUseCase.findById(articleId)
        );

        Link self = WebMvcLinkBuilder
                .linkTo(ArticleController.class)
                .slash(articleId)
                .withSelfRel();

        articleResponseModel.add(self);

        Link parentLink = WebMvcLinkBuilder
                .linkTo(ArticleController.class)
                .withRel("parent");

        articleResponseModel.add(parentLink);

        return articleResponseModel;
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

    @GetMapping("/search")
    public CollectionModel<DetailArticleResponse> search(@RequestParam String text) {
        List<DetailArticleResponse> articleList = findArticleUseCase.search(text);

        Link methodLink = WebMvcLinkBuilder.linkTo(
                        methodOn(ArticleController.class).search(text)
                ).withSelfRel();

        Link selfLink = Link.of(
                URLDecoder.decode(methodLink.getHref(), StandardCharsets.UTF_8),
                LinkRelation.of("self")
        );

        Link parentLink = WebMvcLinkBuilder
                .linkTo(ArticleController.class)
                .withRel("parent");

        return CollectionModel.of(
                articleList,
                selfLink,
                parentLink
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateArticleRequest request) {
        createArticleUseCase.create(request);
    }

    @DeleteMapping("/{articleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long articleId) {
        deleteArticleUseCase.deleteById(articleId);
    }

}
