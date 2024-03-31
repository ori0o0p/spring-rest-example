package rest.project.domain.like.port;

import rest.project.domain.like.model.Like;

public interface SaveLikePort {
    Like save(Like like);

}
