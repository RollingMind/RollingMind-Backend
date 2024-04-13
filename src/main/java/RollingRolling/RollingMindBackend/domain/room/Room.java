package RollingRolling.RollingMindBackend.domain.room;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "rooms")
public class Room {
    @Id
    @Column(nullable = false)
    private String room_id;

    @Column(nullable = false)
    private int host_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomOpen open;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomParticipantionRequest participation_request;

    @Builder
    public Room(String room_id, int host_id, RoomOpen open, RoomParticipantionRequest participation_request){
        this.room_id = room_id;
        this.host_id = host_id;
        this.open = open;
        this.participation_request = participation_request;
    }
}