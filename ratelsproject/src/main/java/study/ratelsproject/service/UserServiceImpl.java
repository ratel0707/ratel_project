package study.ratelsproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.ratelsproject.domain.User;
import study.ratelsproject.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public int addUser() {
        return 0;
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.selectUserByUserId(id);
        return user;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public int deleteUser() {
        return 0;
    }
}
