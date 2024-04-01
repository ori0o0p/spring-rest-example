package rest.project.domain.like.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.RepresentationModel;

public class IsLikeResponseModel extends RepresentationModel<IsLikeResponseModel> {

    public IsLikeResponseModel(IsLikeResponse isLikeResponse) {
        this.isLikeResponse = isLikeResponse;
    }

    @JsonUnwrapped
    private final IsLikeResponse isLikeResponse;

}
