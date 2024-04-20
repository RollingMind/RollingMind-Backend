package RollingRolling.RollingMindBackend.controller.user;


import RollingRolling.RollingMindBackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원번호 생성
    @GetMapping
    public ResponseEntity<?> createMemberNum(){
        Long member_num = userService.generateMemberNum();
        return ResponseEntity.ok().body(Map.of("member_num", member_num));
    }

}
