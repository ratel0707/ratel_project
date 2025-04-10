package study.ratelsproject.repository.postRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import study.ratelsproject.domain.Post;
import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class PostRepositoryImplJdbcTemplate implements PostRepository{

    public final JdbcTemplate jdbcTemplate;

    @Override
    public int createPost(Post post) {
        return 0;
    }

    @Override
    public Post selectPostByPostId(int id) {
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
