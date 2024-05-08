package RollingRolling.RollingMindBackend.dto.postit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PositRequest {
    private String roomId;
    private String nickname;
    private String content;

}