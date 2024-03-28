package rest.project.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.project.domain.comment.dao.CommentRepository;
import rest.project.domain.comment.dto.CreateCommentRequest;
import rest.project.domain.comment.model.Comment;
import rest.project.domain.comment.port.FindCommentPort;
import rest.project.domain.comment.usecase.CreateCommentUseCase;
import rest.project.domain.comment.usecase.DeleteCommentUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentController {
    private final CreateCommentUseCase createCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateCommentRequest request, @PathVariable Long articleId) {
        createCommentUseCase.create(request, articleId);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String articleId, @PathVariable Long commentId) {
        deleteCommentUseCase.deleteById(commentId);
    }

}
