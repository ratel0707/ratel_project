package study.ratelsproject.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import study.ratelsproject.dao.MemberDao;
import study.ratelsproject.domain.Member;
import study.ratelsproject.dto.requestDto.MemberSignIn;
import study.ratelsproject.repository.memberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public int addMember(Member member) {
        MemberDao memberDao = new MemberDao();
        return memberRepository.createMember(memberDao);
    }

    @Override
    public Member getMemberById(int id) {
        System.out.println("getMemberById JDBCTemplate");
        return memberRepository.selectUserByMemberId(id);
    }

    @Override
    public int updateMember(int id, Member member) {
        //아니면 DTO로 새로 생성해서 memberRepository.updateMember의 반환값이 1일때,
        //Member 객체 반환
        MemberDao memberDao = new MemberDao();
        return memberRepository.updateMember(id, memberDao);
    }

    @Override
    public int deleteMemberById(int id) {
        return memberRepository.deleteUserByMemberId(id);
    }

    @Override
    public Member checkMemberSignInValidity(MemberSignIn member) {
        return null;
    }
}
