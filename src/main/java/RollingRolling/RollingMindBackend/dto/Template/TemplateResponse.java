package RollingRolling.RollingMindBackend.dto.Template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface TemplateResponse {
    int getTemplateId();
    String getOptionValue();
}
