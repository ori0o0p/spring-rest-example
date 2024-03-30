package rest.project.domain.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.project.domain.tag.model.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {
}
