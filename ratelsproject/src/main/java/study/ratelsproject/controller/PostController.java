package study.ratelsproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.ratelsproject.domain.Post;
import study.ratelsproject.service.postService.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {
    private final PostService postService;

    @GetMapping("/memberId/{memberId}")
    public List<Post> selectPostsByMemberId(@PathVariable int memberId) {
        return postService.selectPostsByMemberId(memberId);
    }

    @GetMapping("/{id}")
    public Post selectPostById(@PathVariable int id) {
        return postService.selectPostById(id);
    }

    @GetMapping("/all")
    public List<Post> selectAllPosts() {
        return postService.selectAllPosts();
    }

    @PostMapping("/new")
    public void createPost(@RequestBody Post post) {
        post.info();

        postService.insertPost(post);
    }
}
