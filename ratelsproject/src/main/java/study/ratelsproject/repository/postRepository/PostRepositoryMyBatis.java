package study.ratelsproject.repository.postRepository;

import org.apache.ibatis.annotations.Mapper;
import study.ratelsproject.domain.Post;

import java.util.List;

@Mapper
public interface PostRepositoryMyBatis {
    public int insertPost(Post post);
    public List<Post> selectPostsByMemberId(int id);
    public List<Post> selectAllPosts();
    public Post updatePostById(int id);
    public boolean deletePostById(int id);
}
