package dev.daniyar.posts;


import dev.daniyar.posts.postCont.Post;
import dev.daniyar.posts.postCont.PostController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    List<Post> posts = new ArrayList<>();

    @BeforeEach
    void setUp(){
        posts = List.of(
                new Post(1,1, "Hello world though","This is my first post!", null),
                new Post(2,1,"Second post", "This is my second post!", null)
        );
    }

    //build rest api and list them
    @Test
    void shouldFindAllPosts() throws Exception {

        mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk());
    }
}
