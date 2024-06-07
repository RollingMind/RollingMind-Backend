package RollingRolling.RollingMindBackend.controller.user;


import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.email.EmailCheckRequest;
import RollingRolling.RollingMindBackend.dto.user.LoginRequest;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import RollingRolling.RollingMindBackend.service.email.EmailService;
import RollingRolling.RollingMindBackend.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final EmailService emailService;


    //회원가입
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User Request) {
        User user = userService.save(Request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        LoginRequest login = userService.login(loginRequest);
        if(login == null){
            return "redirect:/login";
        }
        session.setAttribute("userId", login.getUserId());

        //redirect는 경로로 설정
        return "redirect:/";
    }

    //로그아웃
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    //비밀번호 찾기
    @GetMapping("/findPassword")
    public String findPassword(@RequestBody User Request){
        User user = userRepository.findByUserId(Request.getUserId()).get();
        if(user == null && !user.getUserId().equals(Request.getUserId())){
            return "redirect:/findPassword";
        }else {
            return "redirect:/changePassword/{userId}";
        }
    }

    //비밀번호 변경
    @PatchMapping("/changePassword/{userId}")
    public ResponseEntity<?> ChangePW(@PathVariable("userId") String userId, @RequestBody String password){
        User user = userService.update(userId, password);
        return ResponseEntity.ok().body(user);
    }


    // 탈퇴하기
    @PostMapping("/withdrawal/{id}")
    public String userWithdrawal(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/login";
    }

    //이메일 인증
    @PostMapping("/emailConfirm")
    public String emailConfirm(@RequestParam("email") String email) throws Exception {

        String confirm = emailService.sendSimpleMessage(email);

        return confirm;
    }

    // 인증번호 일치 확인
    @PostMapping("/emailConfirm/codeCheck")
    public ResponseEntity<?> confirmEmail(@RequestBody EmailCheckRequest emailDto) {
        return ResponseEntity.ok(emailService.confirmEmail(emailDto));
    }

    // 아이디 찾기
    @PostMapping("/findUserId")
    public String findUserId(@RequestBody User Request) {
        User user = userRepository.findByEmail(Request.getEmail()).get();
        System.out.println(Request.getUserId());
        return "redirect:/login";
    }
}
