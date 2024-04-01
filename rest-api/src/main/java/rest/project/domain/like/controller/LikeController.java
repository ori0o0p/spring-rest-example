package rest.project.domain.like.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.project.domain.like.dto.IsLikeResponse;
import rest.project.domain.like.dto.IsLikeResponseModel;
import rest.project.domain.like.usecase.DeleteLikeUseCase;
import rest.project.domain.like.usecase.FindLikeUseCase;
import rest.project.domain.like.usecase.SaveLikeUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles/{articleId}/likes")
public class LikeController {
    private final SaveLikeUseCase saveLikeUseCase;
    private final DeleteLikeUseCase deleteLikeUseCase;
    private final FindLikeUseCase findLikeUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable Long articleId) {
        saveLikeUseCase.save(articleId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long articleId) {
        deleteLikeUseCase.deleteById(articleId);
    }

    @GetMapping
    public IsLikeResponseModel find(@PathVariable Long articleId) {
        IsLikeResponseModel isLikeResponseModel = new IsLikeResponseModel(
                findLikeUseCase.isLike(articleId)
        );

        Link self = WebMvcLinkBuilder
                .linkTo(LikeController.class)
                .withSelfRel();

        isLikeResponseModel.add(self);

        return isLikeResponseModel;
    }

}
