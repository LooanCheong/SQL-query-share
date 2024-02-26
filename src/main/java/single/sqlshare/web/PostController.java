package single.sqlshare.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import single.sqlshare.domain.Post;
import single.sqlshare.service.PostService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String postForm(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "post/post";
    }

    @PostMapping("/")
    public String post(@Valid PostForm form, BindingResult result) {

        LocalDateTime dateTime = LocalDateTime.now();

        Post post = new Post(form.getPassword(), dateTime, form.getQuestionLink(), form.getContent());

        postService.save(post);

        return "redirect:/post";
    }
}
