package study.ratelsproject.repository.postRepository;

import study.ratelsproject.domain.Post;

import java.util.List;

public interface PostRepository {
    public int createPost(Post post);

    public Post selectPostByPostId(int id);

    public int updatePost(Post post);

    public int deletePostByPostId(int id);

    public List<Post> selectAllPostsByMemberId(int id);
}
