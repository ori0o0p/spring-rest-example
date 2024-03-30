package rest.project.domain.tag.dto;

import lombok.Builder;
import rest.project.domain.tag.model.Tag;

@Builder
public record TagResponse(
        String id
) {

    public static Tag toTagEntity(String id) {
        return Tag.builder()
                .id(id)
                .build();
    }

    public static TagResponse from(Tag tag) {
        return TagResponse.builder()
                .id(tag.getId())
                .build();
    }

}
