package study.ratelsproject.repository.memberRepository;

import study.ratelsproject.domain.Member;

public interface MemberRepository {
    public int createMember(Member member);//create

    public Member selectUserByMemberId(int id);//read

    public int deleteUserByMemberId(int id);//delete

    public int updateMember(int id, Member member);
}
