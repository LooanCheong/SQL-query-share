package single.sqlshare.domain;

import jakarta.persistence.*;
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

    @Column(columnDefinition = "TEXT")
    private String content;
}
