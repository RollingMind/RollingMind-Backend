package RollingRolling.RollingMindBackend.validator;

import RollingRolling.RollingMindBackend.dto.user.SignupRequest;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckUserIdValidator extends AbstractValidator<SignupRequest>{
    @Autowired
    private final UserRepository userRepository;

    @Override
    protected void doValidate(SignupRequest signupRequest, Errors errors) {
        if(userRepository.existsByUserId(signupRequest.getUserId())){
            errors.rejectValue("userId", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
        }

    }

}
