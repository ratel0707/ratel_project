package study.ratelsproject.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import study.ratelsproject.domain.Member;
import study.ratelsproject.dto.requestDto.MemberSignIn;
import study.ratelsproject.repository.memberRepository.MemberRepositoryMyBatis;

@Service
@Primary
@RequiredArgsConstructor
public class MemberServiceImplMyBatis implements MemberService {
    private final MemberRepositoryMyBatis memberMapper;

    @Override
    public int addMember(Member member) {
        return 0;
    }

    @Override
    public Member getMemberById(int id) {
        System.out.println("getMemberById by MyBatis");
        return memberMapper.selectMemberById(id);
    }

    @Override
    public int updateMember(int id, Member member) {
        return 0;
    }

    @Override
    public int deleteMemberById(int id) {
        return 0;
    }

    @Override
    public Member checkMemberSignInValidity(MemberSignIn member) {
        Member memberRes = memberMapper.selectMemberByMemberId(member.id());
        //System.out.println(memberRes);
       return memberRes;
        //return (memberRes != null) && member.password().equals(memberRes.getPassword());
    }
}
