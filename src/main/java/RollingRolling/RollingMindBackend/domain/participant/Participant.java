package RollingRolling.RollingMindBackend.domain.participant;

import RollingRolling.RollingMindBackend.domain.room.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "member_num", nullable = false)
    private int member_num;

    @Enumerated(EnumType.STRING)
    private ParticipantStatus status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id", insertable=false, updatable=false)
    private Room room;

    @Builder
    public Participant(String roomId, int member_num, ParticipantStatus status){
        this.roomId = roomId;
        this.member_num = member_num;
        this.status = status;
    }

    public void update(ParticipantStatus status){
        this.status = status;
    }
}
