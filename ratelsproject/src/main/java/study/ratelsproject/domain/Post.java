package study.ratelsproject.domain;

import lombok.Getter;

@Getter
public class Post {
    private int id;
    private int memberId;
    private String title;
    private String content;

    public Post id(int _id) {
        this.id = _id;
        return this;
    }

    public Post memberId(int _memberId) {
        this.memberId = _memberId;
        return this;
    }

    public Post title(String _title) {
        this.title = _title;
        return this;
    }

    public Post content(String _content) {
        this.content = _content;
        return this;
    }

    public Post build(){
        return this;
    }
}
