package RollingRolling.RollingMindBackend.controller.user;

import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.service.user.UserService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/exists")
public class RequestController {
    @Autowired
    private final UserService userService;

    public String joinProc(@Valid User user, BindingResult bindingResult, Model model) {

        /* 검증 */
        if(bindingResult.hasErrors()) {
            /* 회원가입 실패 시 입력 데이터 값 유지 */
            model.addAttribute("userDto", user);

            /* 유효성 검사를 통과하지 못 한 필드와 메시지 핸들링 */
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
                System.out.println("error message : "+error.getDefaultMessage());
            }

            /* 회원가입 페이지로 리턴 */
            return "api/user";
        }

        // 회원가입 성공 시
        userService.save(user);
        return "redirect:/api/login";
    }
}
