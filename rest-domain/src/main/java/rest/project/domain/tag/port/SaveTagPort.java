package rest.project.domain.tag.port;

import rest.project.domain.tag.model.Tag;

import java.util.Set;

public interface SaveTagPort {
    Tag save(Tag tag);
    void saveAll(Set<Tag> tags);

}
