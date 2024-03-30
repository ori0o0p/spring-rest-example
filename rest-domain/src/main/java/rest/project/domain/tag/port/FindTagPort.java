package rest.project.domain.tag.port;

import rest.project.domain.tag.model.Tag;

import java.util.Optional;

public interface FindTagPort {
    boolean existsById(String id);
    Optional<Tag> findById(String id);

}
