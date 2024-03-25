package rest.project.domain.article.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.RepresentationModel;
import rest.project.domain.article.dto.DetailArticleResponse;

public class ArticleModel extends RepresentationModel<ArticleModel> {

    public ArticleModel(DetailArticleResponse detailArticleResponse) {
        this.detailArticleResponse = detailArticleResponse;
    }

    @JsonUnwrapped
    private final DetailArticleResponse detailArticleResponse;

}
