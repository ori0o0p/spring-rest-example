package rest.project.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import rest.project.domain.article.controller.ArticleController;
import rest.project.domain.article.dto.CreateArticleRequest;
import rest.project.domain.article.dto.DetailArticleResponse;
import rest.project.domain.article.usecase.CreateArticleUseCase;
import rest.project.domain.article.usecase.DeleteArticleUseCase;
import rest.project.domain.article.usecase.FindArticleUseCase;

@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindArticleUseCase findArticleUseCase;

    @MockBean
    private CreateArticleUseCase createArticleUseCase;

    @MockBean
    private DeleteArticleUseCase deleteArticleUseCase;

    private static final String BASE_URL = "http://localhost/api";

    @Test
    public void 전체_게시물_조회시_self_링크_반환_검사() throws Exception {
        List<DetailArticleResponse> articleList = new ArrayList<>();
        articleList.add(new DetailArticleResponse(1L, "제목 1", "내용 1", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        articleList.add(new DetailArticleResponse(2L, "제목 2", "내용 2", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));

        given(findArticleUseCase.findAll()).willReturn(articleList);

        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self.href", is(BASE_URL + "/articles")))
                .andExpect(jsonPath("$._embedded.data.length()", is(articleList.size())));
    }

    @Test
    public void 게시물_조회시_self_링크_parent_링크_반환_검사() throws Exception {
        Long articleId = 1L;
        DetailArticleResponse detailArticleResponse = new DetailArticleResponse(articleId, "제목", "내용", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>());
        given(findArticleUseCase.findById(articleId)).willReturn(detailArticleResponse);

        mockMvc.perform(get("/api/articles/{articleId}", articleId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(articleId.intValue())))
                .andExpect(jsonPath("$._links.self.href", is(BASE_URL + "/articles/" + articleId)))
                .andExpect(jsonPath("$._links.parent.href", is(BASE_URL + "/articles")));
    }

    @Test
    public void 게시물_생성() throws Exception {
        CreateArticleRequest request = new CreateArticleRequest("제목", "내용");

        mockMvc.perform(post("/api/articles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk());

        verify(createArticleUseCase).create(request);
    }

    @Test
    public void 게시물_삭제() throws Exception {
        Long articleId = 1L;

        mockMvc.perform(delete("/api/articles/{articleId}", articleId))
                .andExpect(status().isOk());

        verify(deleteArticleUseCase).deleteById(articleId);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}