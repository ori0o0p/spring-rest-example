package rest.project.domain.like.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import rest.project.domain.article.model.Article;
import rest.project.domain.user.model.User;

@Getter
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @JoinColumn(name = "article_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Article article;

    protected Like() {
    }

    @Builder
    public Like(User user, Article article) {
        this.user = user;
        this.article = article;
    }

}
