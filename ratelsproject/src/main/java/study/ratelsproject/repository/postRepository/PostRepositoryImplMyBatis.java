package study.ratelsproject.repository.postRepository;

import org.springframework.stereotype.Repository;
import study.ratelsproject.domain.Post;

import java.util.List;

@Repository
public class PostRepositoryImplMyBatis implements PostRepository{

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
