package study.ratelsproject.service.postService;

import study.ratelsproject.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> selectPostsByMemberId(int memberId);
    public List<Post> selectAllPosts();
    public Post selectPostById(int id);
    public boolean deletePostById(int id);
    public boolean insertPost(Post post);
}
