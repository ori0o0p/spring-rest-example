package rest.project.domain.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.port.FindArticlePort;
import rest.project.domain.article.usecase.FindArticleUseCase;

import java.util.List;

@Service
@Transactional(readOnly = true)
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
    public List<DetailArticleResponse> search(String text) {
        return findArticlePort.search(text)
                .stream()
                .map(DetailArticleResponse::from)
                .toList();
    }

}
