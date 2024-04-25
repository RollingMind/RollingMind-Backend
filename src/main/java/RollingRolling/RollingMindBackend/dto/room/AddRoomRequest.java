package RollingRolling.RollingMindBackend.dto.room;

import RollingRolling.RollingMindBackend.domain.room.RoomOpen;
import RollingRolling.RollingMindBackend.domain.room.RoomParticipationRequest;
import RollingRolling.RollingMindBackend.domain.room.RoomTemplateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddRoomRequest {
    private String roomId;
    private int hostId;
    private RoomOpen open;
    private RoomParticipationRequest participationRequest;
    private String title;
    private LocalDateTime releaseDate;
    private RoomTemplateType templateType;
    private int templateId;
}
