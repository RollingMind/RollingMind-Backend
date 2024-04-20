package RollingRolling.RollingMindBackend.controller.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.service.template.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/template")
@RequiredArgsConstructor
@RestController
public class TemplateController {
    private final TemplateService templateService;

    @GetMapping("/{memberNum}")
    public ResponseEntity<List<Template>> findTemplateLikes(@PathVariable int memberNum){
        return ResponseEntity.ok().body(templateService.findTemplatesByMemberNum(memberNum));
    }
}
