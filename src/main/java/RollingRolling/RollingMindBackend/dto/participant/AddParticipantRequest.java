package RollingRolling.RollingMindBackend.dto.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddParticipantRequest {
    private String room_id;
    private int user_id;
    private String status;
}
