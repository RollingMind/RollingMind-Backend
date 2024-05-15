package RollingRolling.RollingMindBackend.service.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.dto.Template.TemplateResponse;
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
    public List<TemplateResponse> findTemplatesByMemberNum(int memberNum) {
        List<Long> templateIds = templateLikesRepository.findTemplateIdsByMemberNum(memberNum);
        return templateRepository.findByTemplateIds(templateIds);
    }

    public List<Template> findAllTemplates(){  //템플릿 전체 목록 조회
        return templateRepository.findAll();
    }

    public List<Template> searchTemplatesByHashtag(String keyword){
        return templateRepository.findByHashtagContaining(keyword);
    }

    public Template findByTemplateId(int templateId){
        return templateRepository.findByTemplateId(templateId);
    }
}
