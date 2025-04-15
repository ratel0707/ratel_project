package study.ratelsproject.repository.postRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import study.ratelsproject.domain.Post;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
@Primary
@RequiredArgsConstructor
public class PostRepositoryImplJdbcTemplate implements PostRepository{

    public final JdbcTemplate jdbcTemplate;

    @Override
    public int createPost(Post post) {
        String sql = "insert into posts (title, content) values (?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn->{
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            return ps;
        }, keyHolder);

        int generatedKey = -1;
        try{
            generatedKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
        } catch (NullPointerException e) {}

        return generatedKey;
    }

    @Override
    public Post selectPostByPostId(int id) {
        String sql = "select * from posts where id = ?";
        //jdbcTemplate.query(sql, new RowMapper<Post>() {
        //})
        return null;
    }

    @Override
    public int updatePost(Post post) {
        return 0;
    }

    @Override
    public int deletePostByPostId(int id) {
        return 0;
    }

    @Override
    public List<Post> selectAllPostsByMemberId(int id) {
        return List.of();
    }
}
