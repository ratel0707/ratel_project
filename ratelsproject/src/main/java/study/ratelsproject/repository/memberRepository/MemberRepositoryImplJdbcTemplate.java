package study.ratelsproject.repository.memberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import study.ratelsproject.dao.MemberDao;
import study.ratelsproject.domain.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
@Primary
@RequiredArgsConstructor
public class MemberRepositoryImplJdbcTemplate implements MemberRepository {
    @Override
    public int createMember(MemberDao member) {
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
    public int updateMember(int id, MemberDao member) {
        return 0;
    }
    /*
    public final JdbcTemplate jdbcTemplate;

    @Override
    public int createMember(Member member) {
        //KeyHolder를 통해서 insert시 새로 생성된 행에 대해서 PK값을 읽어 올 수있다고 하는데,
        //JPA에서의 영속성 컨텍스트 처럼 메모리에 가지고 있는 것인지?
        //아니면 따로 sql 쿼리를 날려서(insert -> select) 가지고 있는 것인지
        //추후 sql 쿼리 로그찍는 방법 학습 후 시도해보기
        //MySql에서 제공해주는 JDBC기능인 getGeneratedKeys()를 통해 insert 동시에 ID를 가져온다.
        //쿼리를 또 날리는거 아님.

        String sql = "insert into member(memberId, password, nickname, email, phone, role) values(?,?,?,?,?,?)";

        //to get auto increased id value
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //conn은 jdbcTemplate가 내부적으로 DataSource를 통해서 가져온 connection 객채이다.
        //아래 코드는 결국 일반적인 JDBC에서 제공해주는 기능을인 conn.prepareStatement를 통해,
        //쿼리만 작성해주고, 나머지 커넥션 연결, 끊기, 예외 반환 등의 과정을 jdbcTemplate가 알아서 해준다.(.update 함수에서)
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getMemberId());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getNickname());
            ps.setString(4, member.getEmail());
            ps.setString(5, member.getPhone());
            ps.setString(6, member.getRole());
            return ps;
        }, keyHolder);

        int generatedkey = -1;
        try{
            generatedkey = Objects.requireNonNull(keyHolder.getKey()).intValue();
            //null 일때 예외 발생되므로 try로 잡아놈
        } catch (InvalidDataAccessApiUsageException e) {}

        return generatedkey;
    }

    @Override
    public Member selectUserByMemberId(int id) {
        System.out.println("selectUserByMemberId JDBCTemplate");
        String sql = "select * from member where id = ?";
        List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Member()
                        .id(rs.getInt("id"))
                        .nickname(rs.getString("nickname"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .phone(rs.getString("phone"))
                        .role(rs.getString("role"))
                        .build();
            }
        }, id);

        if (list.isEmpty()) {return null;}
        return list.get(0);
    }

    @Override
    public int deleteUserByMemberId(int id) {
        int res = 1;//success

        try{
            String sql = "delete from member where id = ?";
            jdbcTemplate.update(sql, id);
        } catch (InvalidDataAccessApiUsageException e) {
            res = 0;
        }

        return res;
    }

    @Override
    public int updateMember(int id, Member member) {
        int res = 1;

        String sql = "update member set memberId=?, password=?, nickname=?, email=?, phone=?, role=? where id = ?";
        jdbcTemplate.update(sql,
                member.getId(),
                member.getPassword(),
                member.getNickname(),
                member.getEmail(),
                member.getPhone(),
                member.getRole(), id);

        return 0;
    }

     */
}
