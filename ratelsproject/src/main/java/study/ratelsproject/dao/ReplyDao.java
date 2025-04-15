package study.ratelsproject.dao;

import study.ratelsproject.domain.Reply;

public class ReplyDao {
    private int id;
    private int memberId;
    private int postId;
    private String content;

    public ReplyDao id(int _id) {
        this.id = _id;
        return this;
    }

    public ReplyDao memberId(int _memberId) {
        this.memberId = _memberId;
        return this;
    }

    public ReplyDao postId(int _postId) {
        this.postId = _postId;
        return this;
    }

    public ReplyDao content(String _content) {
        this.content = _content;
        return this;
    }

    public ReplyDao build(){
        return this;
    }
}
