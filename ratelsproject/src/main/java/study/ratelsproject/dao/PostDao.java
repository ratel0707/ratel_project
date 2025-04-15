package study.ratelsproject.dao;

import study.ratelsproject.domain.Post;

public class PostDao {
    private int id;
    private int memberId;
    private String title;
    private String content;

    public PostDao id(int _id) {
        this.id = _id;
        return this;
    }

    public PostDao memberId(int _memberId) {
        this.memberId = _memberId;
        return this;
    }

    public PostDao title(String _title) {
        this.title = _title;
        return this;
    }

    public PostDao content(String _content) {
        this.content = _content;
        return this;
    }

    public PostDao build(){
        return this;
    }
}
