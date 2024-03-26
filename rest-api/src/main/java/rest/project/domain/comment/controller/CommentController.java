package rest.project.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rest.project.domain.comment.dto.CreateCommentRequest;
import rest.project.domain.comment.usecase.CreateCommentUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentController {
    private final CreateCommentUseCase createCommentUseCase;

    @PostMapping
    public void create(@RequestBody CreateCommentRequest request, @PathVariable Long articleId) {
        createCommentUseCase.create(request, articleId);
    }

}
