package RollingRolling.RollingMindBackend.domain.Friends_list;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Friends_list")
public class Friends_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_user", nullable = false)
    private int to_user;

    @Column(name = "from_uesr", nullable = false)
    private int from_user;

    @Column(name = "are_we_friend", nullable = false)
    private boolean are_we_firned;

    public Friends_list(int to_user, int from_user, boolean are_we_firned) {
        this.to_user = to_user;
        this.from_user = from_user;
        this.are_we_firned = are_we_firned;
    }
    public void update(int to_user, int from_user, boolean are_we_firned) {
        this.to_user = to_user;
        this.from_user = from_user;
        this.are_we_firned = are_we_firned;
    }
}
