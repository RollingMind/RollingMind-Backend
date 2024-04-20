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

    @Column(nullable = false, name = "roomId")
    private String roomId;

    @Column(nullable = false, name = "hostId")
    private int hostId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomOpen open;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomParticipantionRequest participationRequest;

    @Column(nullable = false)
    private String title;

    @Column
    private LocalDateTime releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomTemplateType templateType;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Participant> participantList;

    @Builder
    public Room(String roomId, int hostId, RoomOpen open, RoomParticipantionRequest participationRequest, String title, LocalDateTime releaseDate, RoomTemplateType templateType){
        this.roomId = roomId;
        this.hostId = hostId;
        this.open = open;
        this.participationRequest = participationRequest;
        this.title = title;
        this.releaseDate = releaseDate;
        this.templateType = templateType;
    }
}