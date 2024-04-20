package RollingRolling.RollingMindBackend.domain.postit;

import RollingRolling.RollingMindBackend.domain.room.Room;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post_it")
public class PostIt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String roomId;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String content;

    @Builder
    public PostIt(String roomId, String nickname, String content){
        this.roomId = roomId;
        this.nickname = nickname;
        this.content = content;
    }

    public void update(String content){
        this.content = content;
    }
}
