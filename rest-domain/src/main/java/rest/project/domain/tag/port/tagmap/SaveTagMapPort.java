package rest.project.domain.tag.port.tagmap;

import rest.project.domain.tag.model.tagmap.TagMap;

import java.util.Set;

public interface SaveTagMapPort {
    TagMap save(TagMap tagMap);
    void saveAll(Set<TagMap> tagMaps);

}
