package study.ratelsproject.repository;

import org.springframework.stereotype.Repository;
import study.ratelsproject.domain.User;

@Repository
public class UserRepositoryImplJpa implements UserRepository {
    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public User selectUserByUserId(int id) {
        return null;
    }

    @Override
    public int deleteUserByUserId(int id) {
        return 0;
    }
}
