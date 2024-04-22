package RollingRolling.RollingMindBackend.dto.Template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
public class TemplateResponse {
    private int templateId;
    private String image;

    public TemplateResponse(Template template){
        this.templateId = template.getTemplateId();
        this.image = template.getOptionValue();
    }
}
