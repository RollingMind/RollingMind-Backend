package RollingRolling.RollingMindBackend.dto.participant;

import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddParticipantRequest {
    private String room_id;
    private int member_num;
    private ParticipantStatus status;
}
