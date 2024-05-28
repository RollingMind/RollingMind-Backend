package RollingRolling.RollingMindBackend.dto.postit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostItUpdateRequest {
    private String content;
    private String color;
    private String author;
}