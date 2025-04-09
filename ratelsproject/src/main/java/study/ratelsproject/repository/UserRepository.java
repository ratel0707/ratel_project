package study.ratelsproject.repository;

import study.ratelsproject.domain.User;

public interface UserRepository {
    //DB접근과 관련된 모든 코드
    //service에서 DB접근에 대해서 관심 분리

    public int createUser(User user);//create

    public User selectUserByUserId(int id);//read

    public int deleteUserByUserId(int id);//delete
}
