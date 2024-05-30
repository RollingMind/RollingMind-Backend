package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.user.LoginRequest;
import RollingRolling.RollingMindBackend.dto.user.SignupRequest;
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


@Service
@Component
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


//    @Transactional
//    public boolean existsByUserId(String userId){
//        return userRepository.existsByUserId(userId);
//    }

    // 회원가입
    public User save(User Request){
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
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



//    // 중복 처리
//    public boolean checkUserIdDuplication(String userId){
//        return userRepository.existsByUserId(userId);
//    }
//    public boolean checkNicknameDuplication(String nickname){
//        return userRepository.existsByNickname(nickname);
//    }


    //로그인
    public LoginRequest login(LoginRequest loginRequest){
        Optional<User> byUserId = userRepository.findByUserId(loginRequest.getUserId());
        if(byUserId.isPresent()){
            User user = byUserId.get();
            if(user.getPassword().equals(loginRequest.getPassword())){
                System.out.println(user.getUserId()+user.getPassword());
                return loginRequest;
            }
        }
        return null;
    }


//    // 탈퇴하기
//    public boolean withdrawal(String userId, String password) {
////        User  = userRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
//
////        if (passwordEncoder.matches(password, user.getPassword())) {
////            userRepository.delete(user);
////            return true;
////        } else {
////            return false;
////        }
//        return  false;
//    }
}
