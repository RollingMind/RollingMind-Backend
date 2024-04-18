package RollingRolling.RollingMindBackend.service.user;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.create.user.Login;
import RollingRolling.RollingMindBackend.dto.create.user.UserDto;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import RollingRolling.RollingMindBackend.service.user.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @DisplayName("Users 테이블 조회")
    @Test
    public void selectUser(){
        List<User> users = userRepository.findAll();
        for(User user : users){
            System.out.println("-----------------------------------------------------------");
            System.out.println("user_id : " + user.getUser_id());
            System.out.println("password : " + user.getPassword());
            System.out.println(user.getName());
            System.out.println(user.getNickname());
            System.out.println(user.getEmail());
            System.out.println(user.getLogin());
            System.out.println(user.getCreated_date());
        }

    }


    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest(){
        User userDto = User.builder()
                .member_num(123123)
                .user_id("test")
                .password("1111")
                .name("홍길동")
                .nickname("길동이")
                .email("test@email.com")
                .created_date("2024-04-18 19:29:10")
                .login(Login.KAKAO)
                .build();

        System.out.println(userDto.getUser_id());

        userService.saveUser(userDto);
//        assertEquals(user.getId(), savedUser.getId());
//        assertEquals(user.getUser_id(), savedUser.getUser_id());
//        assertEquals(user.getPassword(), savedUser.getPassword());
//        assertEquals(user.getName(), savedUser.getName());
//        assertEquals(user.getNickname(), savedUser.getNickname());
//        assertEquals(user.getEmail(), savedUser.getEmail());
//        assertEquals(user.getCreatedDate(), savedUser.getCreatedDate());
//        assertEquals(user.getLogin(), savedUser.getLogin());
    }

//    @Test
//    @DisplayName("중복 회원 테스트")
//    public void saveDuplicateUserTest(){
//        User user1 = saveUserTest();
//        User user2 = saveUserTest();
//
//        userService.saveUser(user1);
//        Throwable e = assertThrows(IllegalStateException.class, () -> {
//            userService.saveUser(user2);
//        });
//        assertEquals("이미 가입된 회원입니다.", e.getMessage());
//    }
}