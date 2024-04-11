package RollingRolling.RollingMindBackend.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCreateRequest {
    private String room_id;
    private int host_id;
    private String open;
    private String participation_request;
    private String title;
    private LocalDateTime release_date;
    private String content;
    private String template;
}
