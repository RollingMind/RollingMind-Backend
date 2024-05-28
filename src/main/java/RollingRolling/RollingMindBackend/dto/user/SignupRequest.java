package RollingRolling.RollingMindBackend.dto.user;

import RollingRolling.RollingMindBackend.domain.user.LoginWay;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private int id;
    private String userId;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String createdDate;
    private LoginWay loginWay;
}
