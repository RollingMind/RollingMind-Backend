package RollingRolling.RollingMindBackend.service.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.dto.Template.TemplateResponse;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.TemplateNotFoundException;
import RollingRolling.RollingMindBackend.repository.template.TemplateLikesRepository;
import RollingRolling.RollingMindBackend.repository.template.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateService {
    private final TemplateLikesRepository templateLikesRepository;
    private final TemplateRepository templateRepository;

    public List<TemplateResponse> findTemplatesById(int id) {
        List<Long> templateIds = templateLikesRepository.findTemplateIdsById(id);
        return templateRepository.findByTemplateIds(templateIds);
    }

    public List<Template> findAllTemplates(){  //템플릿 전체 목록 조회
        return templateRepository.findAll();
    }

    public List<Template> searchTemplatesByHashtag(String keyword){
        return templateRepository.findByHashtagContaining(keyword);
    }

    public Template findByTemplateId(int templateId) throws TemplateNotFoundException {
        return templateRepository.findByTemplateId(templateId)
                .orElseThrow(() -> new TemplateNotFoundException(ErrorCode.TEMPLATE_NOT_FOUND));
    }

    public List<TemplateResponse> findPopularTemplates(){
        return templateRepository.findTemplatesOrderByLikesCount();
    }
}
