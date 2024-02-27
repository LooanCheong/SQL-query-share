package single.sqlshare.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostForm {

    private LocalDateTime postTime;
    private String questionLink;

    @NotBlank(message = "내용은 필수입니다")
    private String content;
}
