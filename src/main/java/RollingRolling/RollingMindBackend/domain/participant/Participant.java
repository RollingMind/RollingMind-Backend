package RollingRolling.RollingMindBackend.domain.participant;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "participants")
public class Participant {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String room_id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private String status;

    @Builder
    public Participant(String room_id, int user_id, String status){
        this.room_id = room_id;
        this.user_id = user_id;
        this.status = status;
    }
}
