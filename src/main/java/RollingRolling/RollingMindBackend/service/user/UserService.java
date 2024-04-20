package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Transactional
public class UserService {
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private  final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public User save(User userDto){
        User user = User.builder()
                .member_num(userDto.getMember_num())
                .user_id(userDto.getUser_id())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .created_date(userDto.getCreated_date())
                .login(userDto.getLogin())
                .build();

        userRepository.save(user);

        return user;
    }

    // 회원 번호 생성
    public Long generateMemberNum(){
        Random random = new Random();
        Long member_num;
        do {
            member_num = random.nextLong(100000) + 99999;
        }while (userRepository.existsById(member_num));
        return member_num;
    }
}
