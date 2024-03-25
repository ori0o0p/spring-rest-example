package rest.project.domain.article.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.RepresentationModel;

public class ArticleModel extends RepresentationModel<ArticleModel> {

    public ArticleModel(Article article) {
        this.article = article;
    }

    @JsonUnwrapped
    private final Article article;

}
