package RollingRolling.RollingMindBackend.dto.participant;

import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantStatusUpdateRequest {
    private ParticipantStatus status;
}
