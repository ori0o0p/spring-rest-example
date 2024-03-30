package rest.project.domain.tag.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest.project.domain.tag.model.Tag;
import rest.project.domain.tag.port.DeleteTagPort;
import rest.project.domain.tag.port.FindTagPort;
import rest.project.domain.tag.port.SaveTagPort;
import rest.project.domain.tag.repository.TagRepository;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TagAdapter implements SaveTagPort, FindTagPort, DeleteTagPort {
    private final TagRepository tagRepository;

    @Override
    public boolean existsById(String id) {
        return tagRepository.existsById(id);
    }

    @Override
    public Optional<Tag> findById(String id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void saveAll(Set<Tag> tags) {
        tagRepository.saveAll(tags);
    }

}
