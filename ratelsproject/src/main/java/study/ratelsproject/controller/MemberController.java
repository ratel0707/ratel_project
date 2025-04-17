package study.ratelsproject.controller;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.ratelsproject.domain.Member;
import study.ratelsproject.dto.requestDto.MemberSignIn;
import study.ratelsproject.dto.responseDto.MemberInfo;
import study.ratelsproject.dto.sessionDto.MemberSession;
import study.ratelsproject.service.memberService.MemberService;
import study.ratelsproject.util.Response;
//import study.ratelsproject.service.memberService.MemberService;

import java.net.BindException;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
//URL(URI) 매핑과 비즈니스 로직을 serviec와 분리한거라고 보면 될듯
public class MemberController {
    //private final MemberService memberService;
    private final MemberService memberService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/test2")
    public ResponseEntity<Response<MemberSignIn>> test2() {
        MemberSignIn memberSignIn = new MemberSignIn("admin", "admin");
        return ResponseEntity.ok().body(new Response<>(memberSignIn, 1));
    }

    //http method (GET, PUT, POST, PATCH, DELETE)
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable("id") int id){
        System.out.println("getMemberById in Controller");
        Member member = memberService.getMemberById(id);
        if(member == null){
            return new Member()
                    .id(123)
                    .nickname("fail");
        }
        return member;
    }

    //FE -> BE XXXXRequestDto / ResponseDto
    //BE
    //Controller -> Service XXXDto
    @PostMapping("/new")
    //ResponseEntity
    public  String createMember(@RequestBody Member member){
        int res = 1;
        //repository에서 insert 구현
        //int res = memberService.addMember(member);
        if(res == -1){
            return "FAIL...";
        }

        return "OK";
    }

    //ResponseUtil.
    @PostMapping("/signIn")
    public ResponseEntity<Response<MemberInfo>> signIn(@RequestBody MemberSignIn member, HttpSession session){
        System.out.println("id: " + member.id());
        System.out.println("password: " + member.password());
        Member res = memberService.checkMemberSignInValidity(member);

        if(res!=null){
            System.out.println("success");
            //Member to MemberInfo
            MemberInfo memberInfo = new MemberInfo(res.getId(), res.getNickname(), res.getEmail(), res.getRole());
            //Member to MemberSession
            MemberSession memberSession = new MemberSession(res.getId(), res.getMemberId());

            //seeeion에 저장
            session.setAttribute("member", memberSession);
            System.out.println("session: " + memberSession);
            return ResponseEntity.ok().body(new Response<>(memberInfo, 1));
        }else{
            System.out.println("fail");
            return ResponseEntity.ok().body(new Response<>(null, 1));
        }
    }

    @PostMapping("/signOut")
    public ResponseEntity<Response<Void>> signOut(HttpSession session){
        MemberSession memberSession = (MemberSession) session.getAttribute("member");
        System.out.println("session in signOut: " + memberSession);
        if(session.getAttribute("member") != null) {
            //클라에서 로그인 상태에서 -> 로그 아웃 요청
            session.removeAttribute("member");
            System.out.println("success sign out");
        }else {
            System.out.println("fail sign out");
        }
        return ResponseEntity.ok().body(new Response<>(null, 1));
    }
    //Spring에서 지원해주는 Http 요청, 응답을 손쉽게 조작 및 생성할 있게 해주는 객체
    //듈다 HttpEntity를 상속함
    //RequestEntity<?>
    //ResponseEntity<?>
}

