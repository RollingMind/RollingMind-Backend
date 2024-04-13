package RollingRolling.RollingMindBackend.domain.member;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private int id;
    private String user_id;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String createdDate;

    //비밀번호 암호화
    public void encodingPassword(PasswordEncoder passwordEncoder){
        if(StringUtils.isEmpty(password)){
            return;
        }
        password = passwordEncoder.encode(password);
    }

}
