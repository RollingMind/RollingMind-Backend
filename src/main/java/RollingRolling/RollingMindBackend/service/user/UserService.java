package RollingRolling.RollingMindBackend.service.user;


import RollingRolling.RollingMindBackend.domain.friendslist.FriendsList;
import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
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


    // 회원가입
    public User save(User Request) {
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


    //로그인
    public LoginRequest login(LoginRequest loginRequest) {
        System.out.println(loginRequest.getUserId());
        Optional<User> byUserId = userRepository.findByUserId(loginRequest.getUserId());
        if (byUserId.isPresent()) {
            User user = byUserId.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return loginRequest;
            }
        }
        return null;
    }

    public User update(String userId, String password){  //비밀번호 변경
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. id: " + userId));

        user.update(passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
    }

}
