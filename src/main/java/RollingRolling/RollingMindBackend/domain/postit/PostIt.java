package RollingRolling.RollingMindBackend.domain.postit;

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

    @Column(nullable = false)
    private String room_id;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String content;

    @Builder
    public PostIt(String room_id, String nickname, String content){
        this.room_id = room_id;
        this.nickname = nickname;
        this.content = content;
    }

    public void update(String content){
        this.content = content;
    }
}
