package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.dto.CreateArticleRequest;
import rest.project.domain.article.model.Article;
import rest.project.domain.article.port.SaveArticlePort;
import rest.project.domain.article.usecase.CreateArticleUseCase;
import rest.project.domain.tag.model.Tag;
import rest.project.domain.tag.model.tagmap.TagMap;
import rest.project.domain.tag.port.FindTagPort;
import rest.project.domain.tag.port.tagmap.SaveTagMapPort;
import rest.project.domain.tag.port.SaveTagPort;
import rest.project.domain.user.service.CurrentUser;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateArticleService implements CreateArticleUseCase {
    private final SaveArticlePort saveArticlePort;
    private final SaveTagMapPort saveTagMapPort;
    private final SaveTagPort saveTagPort;
    private final FindTagPort findTagPort;
    private final CurrentUser currentUser;

    @Override
    public void create(CreateArticleRequest request) {
        Article article = saveArticlePort.save(
                CreateArticleRequest.toArticleEntity(
                        request,
                        currentUser.execute()
                )
        );

        if (!request.tags().isEmpty()) {
            saveTags(article, request.tags());
        }
    }

    private void saveTags(Article article, Set<String> tags) {
        Set<TagMap> tagMaps = new HashSet<>();

        tags.forEach(tagId -> {
            Tag tag = findTagPort.findById(tagId)
                    .orElseGet(() -> saveTagPort.save(new Tag(tagId)));

            tagMaps.add(TagMap.builder()
                    .article(article)
                    .tag(tag)
                    .build());
        });

        saveTagMapPort.saveAll(tagMaps);
    }

}
