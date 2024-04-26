package RollingRolling.RollingMindBackend.domain.FriendsList;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "friends_list")
public class FriendsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_user", nullable = false)
    private int toUser;

    @Column(name = "from_user", nullable = false)
    private int fromUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "situation", nullable = false)
    private FriendsListSituation situation;

    public FriendsList(int toUser, int fromUser, FriendsListSituation situation) {
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.situation = situation;
    }
    public void update(int toUser, int fromUser, FriendsListSituation situation) {
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.situation = situation;
    }
}
