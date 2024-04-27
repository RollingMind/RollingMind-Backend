package RollingRolling.RollingMindBackend.validator;

import RollingRolling.RollingMindBackend.dto.user.SignupRequest;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckNicknameValidator  extends AbstractValidator<SignupRequest>{
    @Autowired
    private final UserRepository userRepository;

    @Override
    protected void doValidate(SignupRequest signupRequest, Errors errors) {
        if(userRepository.existsByNickname(signupRequest.getNickname())){
            errors.rejectValue("nickname", "닉네임 중복 오류", "이미 사용중인 닉네임 입니다.");
        }

    }

}