package rest.project.domain.tag.model.tagmap;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import rest.project.domain.article.model.Article;
import rest.project.domain.tag.model.Tag;

@Getter
@Entity
public class TagMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    protected TagMap() {
    }

    @Builder
    public TagMap(Article article, Tag tag) {
        this.article = article;
        this.tag = tag;
    }

}
