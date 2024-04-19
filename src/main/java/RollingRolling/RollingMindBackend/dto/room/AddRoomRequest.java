package RollingRolling.RollingMindBackend.dto.room;

import RollingRolling.RollingMindBackend.domain.room.RoomOpen;
import RollingRolling.RollingMindBackend.domain.room.RoomParticipantionRequest;
import RollingRolling.RollingMindBackend.domain.room.RoomTemplateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddRoomRequest {
    private String room_id;
    private int host_id;
    private RoomOpen open;
    private RoomParticipantionRequest participation_request;
    private String title;
    private LocalDateTime release_date;
    private RoomTemplateType template_type;
}
