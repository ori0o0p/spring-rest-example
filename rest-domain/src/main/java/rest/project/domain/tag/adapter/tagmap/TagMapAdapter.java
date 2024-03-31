package rest.project.domain.tag.adapter.tagmap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest.project.domain.tag.model.tagmap.TagMap;
import rest.project.domain.tag.port.tagmap.FindTagMapPort;
import rest.project.domain.tag.port.tagmap.SaveTagMapPort;
import rest.project.domain.tag.dao.tagmap.TagMapRepository;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TagMapAdapter implements SaveTagMapPort, FindTagMapPort {
    private final TagMapRepository tagMapRepository;

    @Override
    public TagMap save(TagMap tagMap) {
        return tagMapRepository.save(tagMap);
    }

    @Override
    public void saveAll(Set<TagMap> tagMaps) {
        tagMapRepository.saveAll(tagMaps);
    }

    @Override
    public List<TagMap> findAllByArticleId(Long articleId) {
        return tagMapRepository.findAllByArticle_IdOrderByTagAsc(articleId);
    }

    @Override
    public List<TagMap> findAll() {
        return tagMapRepository.findAll();
    }

}
