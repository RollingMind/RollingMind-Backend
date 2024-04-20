package RollingRolling.RollingMindBackend.service.user;

import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.dto.create.user.UserDto;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class UserServiceTest {


    @Autowired
    UserService userService;


    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest() {
        User user = User.builder()
                .member_num(123124)
                .user_id("test")
                .password("1111")
                .name("홍길동")
                .nickname("길동이")
                .email("test@email.com")
                .created_date("2024-04-18 19:29:10")
                .login(Login.KAKAO)
                .build();


        userService.save(user);
    }
}