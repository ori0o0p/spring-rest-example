package rest.project.domain.tag.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import rest.project.domain.tag.model.tagmap.TagMap;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@Table
public class Tag {
    @Id
    private String id;

    @OneToMany(mappedBy = "tag")
    private Set<TagMap> articles = new LinkedHashSet<>();

    protected Tag() {
    }

    @Builder
    public Tag(String id) {
        this.id = id;
    }

}
