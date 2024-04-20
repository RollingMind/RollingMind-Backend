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

    // 회원 번호 생성
    public int generateMemberNum(){
        Random random = new Random();
        int memberNum;
        do {
            memberNum = random.nextInt(100000) + 99999;
        }while (userRepository.existsById(memberNum));
        return memberNum;
    }


    public User save(User userDto){
        User user = User.builder()
                .memberNum(userDto.getMemberNum())
                .userId(userDto.getUserId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .createdDate(userDto.getCreatedDate())
                .login(userDto.getLogin())
                .build();

        userRepository.save(user);

        return user;
    }


}
