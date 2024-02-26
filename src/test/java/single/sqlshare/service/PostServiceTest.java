package single.sqlshare.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import single.sqlshare.domain.Post;
import single.sqlshare.repository.PostRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;

    @Test
    void save() {

        //Given
        Post post = new Post();

        //When
        Long saveId = postService.save(post);

        //Then
        assertThat(saveId).isEqualTo(post.getId());
    }
}