package study.ratelsproject.service.postService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.ratelsproject.domain.Post;
import study.ratelsproject.repository.postRepository.PostRepositoryMyBatis;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepositoryMyBatis postRepositoryMyBatis;

    @Override
    public List<Post> selectPostsByMemberId(int memberId) {
        return postRepositoryMyBatis.selectPostsByMemberId(memberId);
        //return List.of();
    }

    @Override
    public List<Post> selectAllPosts() {
        return postRepositoryMyBatis.selectAllPosts();
        //return List.of();
    }

    @Override
    public Post selectPostById(int id) {
        return null;
        //return postRepositoryMyBatis.updatePostById(id);
    }

    @Override
    public boolean deletePostById(int id) {
        return false;
    }

    @Override
    public boolean insertPost(Post post) {
        int res = postRepositoryMyBatis.insertPost(post);
        System.out.println("res: " + res);
        return true;
    }
}
