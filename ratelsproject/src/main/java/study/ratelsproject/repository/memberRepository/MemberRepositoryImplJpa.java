package study.ratelsproject.repository.memberRepository;

import org.springframework.stereotype.Repository;
import study.ratelsproject.domain.Member;

@Repository
public class MemberRepositoryImplJpa implements MemberRepository {
    @Override
    public int createMember(Member member) {
        return 0;
    }

    @Override
    public Member selectUserByMemberId(int id) {
        return null;
    }

    @Override
    public int deleteUserByMemberId(int id) {
        return 0;
    }

    @Override
    public int updateMember(int id, Member member) {
        return 0;
    }
}
