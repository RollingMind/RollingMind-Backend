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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, name = "room_id")
    private String roomId;

    @Column(nullable = false)
    private int hostId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomOpen open;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomParticipantionRequest participation_request;

    @Builder
    public Room(String roomId, int hostId, RoomOpen open, RoomParticipantionRequest participation_request){
        this.roomId = roomId;
        this.hostId = hostId;
        this.open = open;
        this.participation_request = participation_request;
    }
}