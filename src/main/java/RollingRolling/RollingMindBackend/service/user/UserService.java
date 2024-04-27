package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.user.LoginRequest;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
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
                .loginWay(Request.getLoginWay())
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


    //로그인
    public Login login(LoginRequest req) {
        Optional<Login> optionalUser = userRepository.findByPassword(req.getUserId());

        // loginId와 일치하는 User가 없으면 null return
        if(optionalUser.isEmpty()) {
            return null;
        }

        Login login = optionalUser.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!login.getPassword().equals(req.getPassword())) {
            return null;
        }

        return login;
    }


    // 탈퇴하기
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
