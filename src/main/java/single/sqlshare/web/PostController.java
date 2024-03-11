package single.sqlshare.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import single.sqlshare.domain.Post;
import single.sqlshare.service.PostService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String postForm(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "post/post";
    }

    @PostMapping("/")
    public String post(@Valid PostForm form, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            log.info("error");
            return "post/post";
        }

        Post post = new Post(LocalDateTime.now(), form.getQuestionLink(), form.getContent());

        postService.save(post);

        redirectAttributes.addAttribute("postId", post.getId());

        return "redirect:/{postId}";
    }

    @GetMapping("/{postId}")
    private String getPost(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findOne(postId);

        model.addAttribute("post", post);
        return "post/getPost";
    }
}
