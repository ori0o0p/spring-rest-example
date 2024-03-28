package rest.project.domain.article.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rest.project.domain.article.model.Article;
import static rest.project.domain.article.model.QArticle.article;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleCustomRepositoryImpl implements ArticleCustomRepository{
    private final JPAQueryFactory query;

    @Override
    public List<Article> search(String text) {
        return query.selectFrom(article)
                .where(article.title.containsIgnoreCase(text)
                        .or(article.content.containsIgnoreCase(text)))
                .orderBy(article.title.asc(), article.id.desc())
                .fetch();
    }

}
