package study.ratelsproject.repository.memberRepository;

import study.ratelsproject.dao.MemberDao;
import study.ratelsproject.domain.Member;

public interface MemberRepository {
    public int createMember(MemberDao member);//create

    public Member selectUserByMemberId(int id);//read

    public int deleteUserByMemberId(int id);//delete

    public int updateMember(int id, MemberDao member);
}
