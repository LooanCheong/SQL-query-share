package single.sqlshare.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

    @Builder
    public Post(String password, LocalDateTime postTime, String questionLink, String content) {
        this.password = password;
        this.postTime = postTime;
        this.questionLink = questionLink;
        this.content = content;
    }
}
