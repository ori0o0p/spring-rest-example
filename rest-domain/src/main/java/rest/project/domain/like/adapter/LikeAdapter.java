package rest.project.domain.like.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest.project.domain.like.model.Like;
import rest.project.domain.like.port.DeleteLikePort;
import rest.project.domain.like.port.FindLikePort;
import rest.project.domain.like.port.SaveLikePort;
import rest.project.domain.like.dao.LikeRepository;

@Component
@RequiredArgsConstructor
public class LikeAdapter implements SaveLikePort, DeleteLikePort, FindLikePort {
    private final LikeRepository likeRepository;

    @Override
    public void deleteByArticleId(Long userId, Long articleId) {
        likeRepository.deleteByUser_IdAndArticle_Id(userId, articleId);
    }

    @Override
    public boolean isLikeCurrentUser(Long userId, Long articleId) {
        return likeRepository.existsByUser_IdAndArticle_Id(userId, articleId);
    }

    @Override
    public Like save(Like like) {
        return likeRepository.save(like);
    }

}
