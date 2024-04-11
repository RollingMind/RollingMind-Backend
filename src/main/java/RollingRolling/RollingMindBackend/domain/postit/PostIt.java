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
    @Column(nullable = false)
    private String room_id;

    @Column(nullable = false)
    private String title;

    @Column
    private LocalDateTime release_date;

    @Column
    private String content;

    @Column(nullable = false)
    private String template;

    @Builder
    public PostIt(String room_id, String title, LocalDateTime release_date, String content, String template){
        this.room_id = room_id;
        this.title = title;
        this.release_date = release_date;
        this.content = content;
        this.template = template;
    }

    public void update(String title, LocalDateTime release_date, String content, String template){
        this.title = title;
        this.release_date = release_date;
        this.content = content;
        this.template = template;
    }
}
