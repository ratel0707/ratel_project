package study.ratelsproject.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.ratelsproject.domain.Member;
import study.ratelsproject.service.memberService.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
//URL(URI) 매핑과 비즈니스 로직을 serviec와 분리한거라고 보면 될듯
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/read-memberById")
    public Member getMemberById(@RequestParam("id") int id){
        Member member = memberService.getMemberById(id);
        if(member == null){
            return new Member()
                    .id(123)
                    .nickname("fail");
        }
        return member;
    }

    @GetMapping("/read-memberByMemberId")
    public String getMemberById(@RequestParam("memberId") String memberId){
        //
        return "OK";
    }

    @PostMapping("/create-member")
    public String createMember(@RequestBody Member member){
        int res = memberService.addMember(member);
        if(res == -1){
            return "FAIL...";
        }

        return "OK";
    }
}
