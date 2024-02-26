package single.sqlshare.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import single.sqlshare.domain.Post;
import single.sqlshare.repository.PostRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {


    private final PostRepository postRepository;

    public Long write(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }
}
