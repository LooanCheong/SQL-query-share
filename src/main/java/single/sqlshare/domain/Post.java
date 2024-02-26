package single.sqlshare.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String password;

    private LocalDateTime postTime;

    private String questionLink;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Post() {
    }

    @Builder
    public Post(Long id, String password, LocalDateTime postTime, String questionLink, String content) {
        this.id = id;
        this.password = password;
        this.postTime = postTime;
        this.questionLink = questionLink;
        this.content = content;
    }
}
