package RollingRolling.RollingMindBackend.dto.postit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostItRequest {
    private String roomId;
    private String nickname;
    private String content;
    private String color;
    private String author;

}