package RollingRolling.RollingMindBackend.domain.room;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(nullable = false, name = "host_id")
    private int hostId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomOpen open;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomParticipantionRequest participation_request;

    @Column(nullable = false)
    private String title;

    @Column
    private LocalDateTime release_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomTemplateType template_type;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Participant> participantList;

    @Builder
    public Room(String roomId, int hostId, RoomOpen open, RoomParticipantionRequest participation_request, String title, LocalDateTime release_date, RoomTemplateType template_type){
        this.roomId = roomId;
        this.hostId = hostId;
        this.open = open;
        this.participation_request = participation_request;
        this.title = title;
        this.release_date = release_date;
        this.template_type = template_type;
    }
}