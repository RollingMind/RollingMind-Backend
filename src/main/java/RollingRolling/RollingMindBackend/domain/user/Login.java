package RollingRolling.RollingMindBackend.domain.user;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Login {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

}
