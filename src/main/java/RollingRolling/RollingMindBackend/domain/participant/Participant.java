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

    @Column(name = "roomId", nullable = false)
    private String roomId;

    @Column(name = "memberNum", nullable = false)
    private int memberNum;

    @Enumerated(EnumType.STRING)
    private ParticipantStatus status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "roomId", insertable=false, updatable=false)
    private Room room;

    @Builder
    public Participant(String roomId, int memberNum, ParticipantStatus status){
        this.roomId = roomId;
        this.memberNum = memberNum;
        this.status = status;
    }

    public void update(ParticipantStatus status){
        this.status = status;
    }
}
