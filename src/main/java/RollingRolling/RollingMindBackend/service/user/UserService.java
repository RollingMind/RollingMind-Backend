package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.user.SignupRequest;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

import static java.time.LocalTime.now;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private  final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public boolean existsByUserId(String userId){
        return userRepository.existsByUserId(userId);
    }

    // 회원가입
    public User save(User Request){
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .memberNum(generateMemberNum())
                .userId(Request.getUserId())
                .password(passwordEncoder.encode(Request.getPassword()))
                .name(Request.getName())
                .nickname(Request.getNickname())
                .email(Request.getEmail())
                .createdDate(String.valueOf(now))
                .login(Request.getLogin())
                .build();

        userRepository.save(user);

        return user;
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
    public boolean checkUserIdDuplication(String userId){
        return userRepository.existsByUserId(userId);
    }
    public boolean checkNicknameDuplication(String nickname){
        return userRepository.existsByNickname(nickname);
    }



    public boolean withdrawal(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));

        if (passwordEncoder.matches(password, user.getPassword())) {
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }
}
