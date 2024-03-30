package rest.project.domain.tag.repository.tagmap;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.project.domain.tag.model.tagmap.TagMap;

import java.util.List;

public interface TagMapRepository extends JpaRepository<TagMap, Long> {
    List<TagMap> findAllByArticle_IdOrderByTagAsc(Long articleId);

}
