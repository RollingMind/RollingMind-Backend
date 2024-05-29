package RollingRolling.RollingMindBackend.domain.user;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Login {
    @Column(name = "userId")
    private String userId;

    @Column(name = "password")
    private String password;

    // 비밀번호 암호화
    public User toEntity(String encodedPassword) {
        return User.builder()
                .userId(this.userId)
                .password(encodedPassword)
                .build();
    }
}
