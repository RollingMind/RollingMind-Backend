package RollingRolling.RollingMindBackend.dto.user;

import RollingRolling.RollingMindBackend.domain.user.Login;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private long id;
    private int memberNum;
    private String userId;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String createdDate;
    private Login login;
}
