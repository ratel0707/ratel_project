package study.ratelsproject.service.memberService;


import study.ratelsproject.domain.Member;
import study.ratelsproject.dto.requestDto.MemberSignIn;

public interface MemberService {
    public int addMember(Member member);//create

    public Member getMemberById(int id);//read

    public int updateMember(int id, Member member);//update

    public int deleteMemberById(int id);//delete

    public Member checkMemberSignInValidity(MemberSignIn member);

    //public String encryptPassword(String password);
}
