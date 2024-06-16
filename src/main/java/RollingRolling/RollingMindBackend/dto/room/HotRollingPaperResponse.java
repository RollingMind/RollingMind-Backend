package RollingRolling.RollingMindBackend.dto.room;

import RollingRolling.RollingMindBackend.domain.room.RoomOpen;
import RollingRolling.RollingMindBackend.domain.room.RoomParticipationRequest;
import RollingRolling.RollingMindBackend.domain.room.RoomTemplateType;

import java.time.LocalDateTime;

public interface HotRollingPaperResponse {
    Long getIdx();
    String getNickname();
    String getImage();
    String getRoomId();
    String getOpen();
    String getParticipationRequest();
    String getTitle();
    String getContent();
    LocalDateTime getReleaseDate();
    String getTemplateType();
    int getParticipantsCount();
}
