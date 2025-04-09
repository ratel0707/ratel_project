package study.ratelsproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;

    //Implement builder pattern
    public User id(int _id) {
        this.id = _id;
        return this;
    }

    public User name(String _name) {
        this.name = name;
        return this;
    }

    public User password(String _password) {
        this.password = _password;
        return this;
    }

    public User email(String _email) {
        this.email = _email;
        return this;
    }

    public User phone(String _phone) {
        this.phone = _phone;
        return this;
    }

    public User build(){
        return this;
    }

    public void info(){
        System.out.println("user " + name);
        System.out.println("email " + email);
        System.out.println("phone " + phone);
        System.out.println("password " + password);
        System.out.println("id " + id);
    }
}
