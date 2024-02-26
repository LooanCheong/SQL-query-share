package single.sqlshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import single.sqlshare.domain.Post;
import single.sqlshare.repository.PostRepository;

@Service
@Transactional(readOnly = true)
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Long write(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }
}
