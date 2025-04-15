package study.ratelsproject.dao;


import study.ratelsproject.domain.Member;

public class MemberDao {
    private int id;
    private String memberId;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String role;

    //Implement builder pattern
    public MemberDao id(int _id) {
        this.id = _id;
        return this;
    }

    public MemberDao memberId(String _memberId) {
        this.memberId = _memberId;
        return this;
    }

    public MemberDao password(String _password) {
        this.password = _password;
        return this;
    }

    public MemberDao nickname(String _nickname) {
        this.nickname = _nickname;
        return this;
    }

    public MemberDao email(String _email) {
        this.email = _email;
        return this;
    }

    public MemberDao phone(String _phone) {
        this.phone = _phone;
        return this;
    }

    public MemberDao role(String _role) {
        this.role = _role;
        return this;
    }

    public MemberDao build(){
        return this;
    }

    public void info(){
        System.out.println("user " + memberId);
        System.out.println("email " + email);
        System.out.println("phone " + phone);
        System.out.println("password " + password);
        System.out.println("id " + id);
    }
}
