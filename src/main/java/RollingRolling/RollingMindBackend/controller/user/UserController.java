package RollingRolling.RollingMindBackend.controller.user;


import RollingRolling.RollingMindBackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    // 회원번호 생성
    @GetMapping("/{memberNum}")
    public ResponseEntity<?> createMemberNum(){
        int memberNum = userService.generateMemberNum();
        return ResponseEntity.ok().body(Map.of("memberNum", memberNum));
    }


    // 아이디 중복 처리
    @GetMapping("/{userId}")
    public ResponseEntity<?> checkUserIdDuplicate(@RequestParam(value = "userId") String userId) throws BadRequestException{
        if(userService.existsByUserId(userId)==true){
            throw new BadRequestException("이미 사용 중인 아이디 입니다.");
        }else {
            return ResponseEntity.ok("사용 가능한 아이디 입니다.");
        }
    }


}
