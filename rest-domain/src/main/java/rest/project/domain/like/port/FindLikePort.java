package rest.project.domain.like.port;

public interface FindLikePort {
    boolean isLikeCurrentUser(Long userId, Long articleId);

}
