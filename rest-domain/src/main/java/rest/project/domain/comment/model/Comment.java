package rest.project.domain.comment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import rest.project.domain.article.model.Article;

import java.time.LocalDateTime;

@Getter
@Entity(name = "comment")
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "article_id")
    private Article article;

    @CreationTimestamp
    private LocalDateTime createdAt;

    protected Comment() {
    }

    @Builder
    public Comment(String content, Article article) {
        this.content = content;
        this.article = article;
    }

}
