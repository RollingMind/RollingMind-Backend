package RollingRolling.RollingMindBackend.controller.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.dto.Template.TemplateResponse;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.TemplateNotFoundException;
import RollingRolling.RollingMindBackend.service.template.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/template")
@RequiredArgsConstructor
@RestController
public class TemplateController {
    private final TemplateService templateService;

    @GetMapping("/{id}/like")
    public ResponseEntity<List<TemplateResponse>> findTemplateLikes(@PathVariable int id){
        return ResponseEntity.ok().body(templateService.findTemplatesByMemberNum(id));
    }

    @GetMapping
    public ResponseEntity<List<Template>> findAllTemplates(){
        return ResponseEntity.ok().body(templateService.findAllTemplates());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Template>> searchTemplates(@RequestParam String keyword) throws TemplateNotFoundException {
        List<Template> templateList = templateService.searchTemplatesByHashtag(keyword);
        if(templateList.isEmpty()){  //검색결과가 없을 경우
            throw new TemplateNotFoundException(ErrorCode.TEMPLATE_NOT_FOUND);
        }
        return ResponseEntity.ok().body(templateList);
    }

    @GetMapping("/{templateId}")
    public ResponseEntity<Template> findByTemplateId(@PathVariable int templateId) throws TemplateNotFoundException {
        return ResponseEntity.ok().body(templateService.findByTemplateId(templateId));
    }

    @GetMapping("/popular")
    public ResponseEntity<List<TemplateResponse>> findPopularTemplates(){
        return ResponseEntity.ok().body(templateService.findPopularTemplates());
    }
}
