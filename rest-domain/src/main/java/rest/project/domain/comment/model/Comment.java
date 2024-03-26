package rest.project.domain.comment.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import rest.project.domain.article.model.Article;

import java.time.LocalDateTime;

@Getter
@Entity(name = "comment")
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private Article article;

    private LocalDateTime createdAt;

    protected Comment() {
    }

    @Builder
    public Comment(String content, Article article) {
        this.content = content;
        this.article = article;
        this.createdAt = LocalDateTime.now();
    }

}
