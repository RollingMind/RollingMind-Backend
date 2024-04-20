package RollingRolling.RollingMindBackend.service.user;

import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.domain.user.Login;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest() {
        User user = User.builder()
                .memberNum(userService.generateMemberNum())
                .userId("test")
                .password("1111")
                .name("홍길동")
                .nickname("동동이")
                .email("test@email.com")
                .createdDate("2024-04-18 19:29:10")
                .login(Login.KAKAO)
                .build();
        System.out.println(user.getMemberNum());
        userService.save(user);
    }

}