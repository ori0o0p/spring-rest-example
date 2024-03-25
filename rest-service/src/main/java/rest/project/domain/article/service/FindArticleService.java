package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.article.usecase.FindArticleUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindArticleService implements FindArticleUseCase {
    private final FindArticlePort findArticlePort;

    @Override
    public DetailArticleResponse findById(Long id) {
        return DetailArticleResponse.from(
                findArticlePort.findById(id)
        );
    }

    @Override
    public List<DetailArticleResponse> findAll() {
        return findArticlePort.findAll()
                .stream()
                .map(DetailArticleResponse::from)
                .toList();
    }

    @Override
    public List<DetailArticleResponse> findAllByTextContaining(String text) {
        return findArticlePort.findAllByTextContaining(text)
                .stream()
                .map(DetailArticleResponse::from)
                .toList();
    }

}
