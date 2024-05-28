package RollingRolling.RollingMindBackend.domain.postit;

import RollingRolling.RollingMindBackend.domain.room.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long idx;

    @Column
    private String roomId;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String content;

    @Column
    private String color;

    @Column
    private String author;

    @Builder
    public PostIt(String roomId, String nickname, String content, String color, String author){
        this.roomId = roomId;
        this.nickname = nickname;
        this.content = content;
        this.color = color;
        this.author = author;
    }

    public void update(String content, String color, String author){
        this.content = content;
        this.color = color;
        this.author = author;
    }
}
