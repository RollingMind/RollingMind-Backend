package RollingRolling.RollingMindBackend.controller.user;


import RollingRolling.RollingMindBackend.domain.friendslist.FriendsList;
import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.friendslist.FriendsListSituationUpdateRequest;
import RollingRolling.RollingMindBackend.dto.user.LoginRequest;
import RollingRolling.RollingMindBackend.dto.user.SignupRequest;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import RollingRolling.RollingMindBackend.service.user.UserService;
import RollingRolling.RollingMindBackend.validator.CheckNicknameValidator;
import RollingRolling.RollingMindBackend.validator.CheckUserIdValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private final CheckUserIdValidator checkUserIdValidator;
    @Autowired
    private final CheckNicknameValidator checkNicknameValidator;
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;

    // 커스텀 유효성 검증을 위해 추가
    @InitBinder
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkUserIdValidator);
        binder.addValidators(checkNicknameValidator);
    }


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
    @PostMapping("/findPassword")
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



//    // 탈퇴하기
//    @PostMapping("/withdrawal")
//    public String memberWithdrawal(@RequestParam String password, Model model, Authentication authentication) {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        boolean result = userService.withdrawal(userDetails.getUsername(), password);
//
//        if (result) {
////            return "redirect:/logout";
//            return password;
//        } else {
//            model.addAttribute("wrongPassword", "비밀번호가 맞지 않습니다.");
//            return "/user/withdrawal";
//        }
//    }
}
