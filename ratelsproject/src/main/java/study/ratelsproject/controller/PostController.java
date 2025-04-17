package study.ratelsproject.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.ratelsproject.domain.Post;
import study.ratelsproject.dto.requestDto.MemberSignIn;
import study.ratelsproject.dto.requestDto.PostNew;
import study.ratelsproject.dto.requestDto.PostNewByMember;
import study.ratelsproject.dto.sessionDto.MemberSession;
import study.ratelsproject.service.postService.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {
    private final PostService postService;

    //사용자의 실제 로그인시 사용하는 ID를 브라우저에 노출하는 것이 옳은가?
    @GetMapping("/member")
    public List<Post> selectPostsByMemberId(HttpSession session) {
        System.out.println("sfsfsfsdfdsfsdfsdfdsfsdfsf");
        MemberSession memberSession = (MemberSession) session.getAttribute("member");
        if(memberSession != null) {
            System.out.println("selectPostsByMemberId");
            return postService.selectPostsByMemberId(memberSession.id());
        }else {
            System.out.println("no session");
        }
        return null;
    }

    @GetMapping("/{id}")
    public Post selectPostById(@PathVariable int id) {
        return postService.selectPostById(id);
    }

    @GetMapping("/all")
    public List<Post> selectAllPosts() {
        return postService.selectAllPosts();
    }

    //그냥 익명으로 로그인 없이 post 생성
    @PostMapping("/new")
    public void createPost(@RequestBody Post post) {
        post.info();
        postService.insertPost(post);
    }

    //로그인 이후, post 생성
    //CSR이므로 굳이 클라에서 로그인 아이디를 가지고 있을 이유가 없음.
    //서버에서만 세션으로 관리하면 됨.
    @PostMapping("/new/member")
    public List<Post> createPostByMemberId(@RequestBody PostNew postNew, HttpSession session) {
        MemberSession member = (MemberSession) session.getAttribute("member");
        //System.out.println(member.id());
        System.out.println("memberid in createPostByMemberId : "  + member.id());
        PostNewByMember postNewByMember = new PostNewByMember(postNew.title(), postNew.content(), member.id());

        //TODO
        //여기서 member.id()로 member table의 PK가 필요함.
        postService.insertPostByMemberId(postNewByMember);
        return null;
    }
}
