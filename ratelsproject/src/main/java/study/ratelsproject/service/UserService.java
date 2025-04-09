package study.ratelsproject.service;

import study.ratelsproject.domain.User;

public interface UserService {
    //비즈니스 로직과 관련된 모든 코드
    public int addUser();//create

    public User getUserById(int id);//read

    public User updateUser();//update

    public int deleteUser();//delete
}
