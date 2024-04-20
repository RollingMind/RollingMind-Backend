package RollingRolling.RollingMindBackend.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "member_num")
    private long member_num;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private String created_date;

    @Column(name = "login")
    @Enumerated(EnumType.STRING)
    private Login login;


    @Builder
    public User(long member_num, String user_id, String password, String name, String nickname, String email, String created_date, Login login) {
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
