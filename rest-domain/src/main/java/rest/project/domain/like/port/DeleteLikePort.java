package rest.project.domain.like.port;

public interface DeleteLikePort {
    void deleteByArticleId(Long userId, Long articleId);

}
