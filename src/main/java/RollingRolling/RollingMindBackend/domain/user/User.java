package RollingRolling.RollingMindBackend.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "memberNum")
    private int memberNum;

    @Column(name = "userId")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "createdDate")
    private String createdDate;

    @Column(name = "login")
    @Enumerated(EnumType.STRING)
    private Login login;


    @Builder
    public User(int memberNum, String userId, String password, String name, String nickname, String email, String createdDate, Login login) {
        this.memberNum = memberNum;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.createdDate = createdDate;
        this.login = login;
    }
}
