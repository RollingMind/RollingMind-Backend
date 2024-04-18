package RollingRolling.RollingMindBackend.domain.user;

import RollingRolling.RollingMindBackend.dto.create.user.Login;
import RollingRolling.RollingMindBackend.dto.create.user.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Member;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int member_num;
    @Column
    private String user_id;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String nickname;
    @Column
    private String email;
    @Column(name = "created_date")
    private String created_date;

    @Column
    @Enumerated(EnumType.STRING)
    private Login login;


    @Builder
    public User(int member_num, String user_id, String password, String name, String nickname, String email, String created_date, Login login) {
        this.member_num = member_num;
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.created_date = created_date;
        this.login = login;
    }
}
