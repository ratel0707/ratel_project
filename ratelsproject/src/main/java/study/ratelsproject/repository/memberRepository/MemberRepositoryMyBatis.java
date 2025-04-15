package study.ratelsproject.repository.memberRepository;

import org.apache.ibatis.annotations.Mapper;
import study.ratelsproject.dao.MemberDao;
import study.ratelsproject.domain.Member;
import study.ratelsproject.dto.requestDto.MemberSignIn;

@Mapper
public interface MemberRepositoryMyBatis {
    public Member selectMemberById(int id);
    public Member selectMemberByMemberId(String memberId);
    public boolean deleteMemberById(int id);
    public boolean updateMember(int id, Member member);
    public Member insertMember(Member member);
}
