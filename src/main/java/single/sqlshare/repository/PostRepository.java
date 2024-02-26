package single.sqlshare.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import single.sqlshare.domain.Post;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }

    public void findOne(Long id) {
        em.find(Post.class, id);
    }
}
