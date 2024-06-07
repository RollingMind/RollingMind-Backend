package RollingRolling.RollingMindBackend.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(unique = true)
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "login_way")
    @Enumerated(EnumType.STRING)
    private LoginWay loginWay;


    @Builder
    public User(int id, String userId, String password, String name, String nickname, String email, String createdDate, LoginWay loginWay) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.createdDate = createdDate;
        this.loginWay = loginWay;
    }

    public void update(String password){
        this.password = password;
    }
}
