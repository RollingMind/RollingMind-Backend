package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.controller.user.UserController;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.user.UserDto;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import static java.time.LocalTime.now;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private  final UserRepository userRepository;



    @Transactional
    public boolean existsByUserId(String userId){
        return userRepository.existsByUserId(userId);
    }

    // 회원 번호 생성
    public int generateMemberNum(){
        Random random = new Random();
        int memberNum;
        do {
            memberNum = random.nextInt(100000) + 99999;
        }while (userRepository.existsByMemberNum(memberNum));
        return memberNum;
    }

    // 중복 처리
    public boolean checkUserIdDuplicate(String userId){
        return userRepository.existsByUserId(userId);
    }


    // 회원 정보 입력
    public User save(User userDto){
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .memberNum(generateMemberNum())
                .userId(userDto.getUserId())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .createdDate(String.valueOf(now))
                .login(userDto.getLogin())
                .build();

        userRepository.save(user);

        return user;
    }


}
