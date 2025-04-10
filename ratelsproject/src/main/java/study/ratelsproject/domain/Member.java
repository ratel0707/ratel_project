package study.ratelsproject.domain;

import lombok.Getter;

@Getter
public class Member {
    private int id;
    private String memberId;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String role;

    //Implement builder pattern
    public Member id(int _id) {
        this.id = _id;
        return this;
    }

    public Member memberId(String _memberId) {
        this.memberId = _memberId;
        return this;
    }

    public Member password(String _password) {
        this.password = _password;
        return this;
    }

    public Member nickname(String _nickname) {
        this.nickname = _nickname;
        return this;
    }

    public Member email(String _email) {
        this.email = _email;
        return this;
    }

    public Member phone(String _phone) {
        this.phone = _phone;
        return this;
    }

    public Member role(String _role) {
        this.role = _role;
        return this;
    }

    public Member build(){
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
