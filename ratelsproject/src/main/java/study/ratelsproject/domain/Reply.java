package study.ratelsproject.domain;

import lombok.Getter;

@Getter
public class Reply {
    private int id;
    private int memberId;
    private int postId;
    private String content;

    public Reply id(int _id) {
        this.id = _id;
        return this;
    }

    public Reply memberId(int _memberId) {
        this.memberId = _memberId;
        return this;
    }

    public Reply postId(int _postId) {
        this.postId = _postId;
        return this;
    }

    public Reply content(String _content) {
        this.content = _content;
        return this;
    }

    public Reply build(){
        return this;
    }
}
