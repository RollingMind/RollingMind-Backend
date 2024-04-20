package RollingRolling.RollingMindBackend.dto.Template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TemplateRequest {
    private int Template_id;
    private String option_value;
    private String hashtag;

}
