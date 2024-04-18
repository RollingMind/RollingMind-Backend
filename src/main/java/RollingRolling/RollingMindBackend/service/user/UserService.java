package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public User saveUser(User user){
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    // 중복회원 확인
    private void validateDuplicateUser(User user){
        User findUser = userRepository.findById(user.getId());
        if(findUser != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
