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

    @Column(name = "room_id", nullable = false)
    private String roomId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Enumerated(EnumType.STRING)
    private ParticipantStatus status;

    @Builder
    public Participant(String roomId, int userId, ParticipantStatus status){
        this.roomId = roomId;
        this.userId = userId;
        this.status = status;
    }

    public void update(ParticipantStatus status){
        this.status = status;
    }
}
