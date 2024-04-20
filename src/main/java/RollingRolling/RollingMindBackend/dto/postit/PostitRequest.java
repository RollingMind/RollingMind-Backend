package RollingRolling.RollingMindBackend.dto.postit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostitRequest {
    private String room_id;
    private String nickname;
    private String context;

}