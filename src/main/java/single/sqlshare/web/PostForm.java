package single.sqlshare.web;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostForm {

    private String password;
    private LocalDateTime postTime;
    private String questionLink;

    @NotEmpty(message = "내용은 필수로 입력해야 합니다.")
    private String content;
}
