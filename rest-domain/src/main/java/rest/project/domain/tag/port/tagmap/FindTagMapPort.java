package rest.project.domain.tag.port.tagmap;

import rest.project.domain.tag.model.tagmap.TagMap;

import java.util.List;

public interface FindTagMapPort {
    List<TagMap> findAllByArticleId(Long articleId);
    List<TagMap> findAll();

}
