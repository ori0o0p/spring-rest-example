package rest.project.domain.article.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.RepresentationModel;

public class ArticleResponseModel extends RepresentationModel<ArticleResponseModel> {

    public ArticleResponseModel(DetailArticleResponse detailArticleResponse) {
        this.detailArticleResponse = detailArticleResponse;
    }

    @JsonUnwrapped
    private final DetailArticleResponse detailArticleResponse;

}
