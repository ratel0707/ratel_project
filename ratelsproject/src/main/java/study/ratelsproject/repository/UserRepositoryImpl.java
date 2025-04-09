package study.ratelsproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import study.ratelsproject.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public DriverManagerDataSource dataSource;
    public JdbcTemplate jdbcTemplate;
    public UserRepositoryImpl() {
        //spring bean으로 등록되는 생성자에서 db연결시 예외 발생하는 경우
        //어떻게 처리해야 하지??, 예외 발생하면 아예 bean으로 등록이 안되나?
        //아니면 빌드 실패가 되나? -> try-catch로 예외 발생해도 그냥 서버 동작하는데,
        //그럼 디비 커넥션을 제대로 못 가져오면 repository는 아예 아무 역할을 할 수 없는데,
        //testcode로 제대로 확인하는 방법이 유일한가?

        /*
        try {
            //throw new Exception("예외 발생");

            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
            dataSource.setUsername("test");
            dataSource.setPassword("test");
        } catch (Exception e) {
            System.out.println("에러 메시지: " + e.getMessage());
        }

         */

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("test");
        dataSource.setPassword("test");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createUser(User user) {
        //return user id
        String sql = "insert into testUserTable (id, password, name, phone, email) values (?, ?, ?, ?, ?)";


        return 0;

        //insert into testUserTable(id, password, name, phone, email)
        //values (1, "user1", "user1_name", "0x01", "user1@lgcns.com"),
    }


    @Override
    public User selectUserByUserId(int id) {
        String sql = "select * from testUsertable where id = ?";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .phone(rs.getString("phone"))
                        .build();

                return user;
            }
        }, id);

        if (list.isEmpty()) {return null;}
        return list.get(0);
    }

    @Override
    public int deleteUserByUserId(int id) {
        return 0;
    }
}