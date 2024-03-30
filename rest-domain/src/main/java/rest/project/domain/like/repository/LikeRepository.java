package rest.project.domain.like.repository;

import org.springframework.data.repository.CrudRepository;
import rest.project.domain.like.model.Like;

public interface LikeRepository extends CrudRepository<Like, Long> {
    boolean existsByUser_IdAndArticle_Id(Long userId, Long articleId);
    void deleteByUser_IdAndArticle_Id(Long userId, Long articleId);

}
