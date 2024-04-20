package RollingRolling.RollingMindBackend.service.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.repository.template.TemplateLikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateService {
    private final TemplateLikesRepository templateLikesRepository;

    public List<Template> findTemplatesByMemberNum(int memberNum){
        return templateLikesRepository.findTemplatesByMemberNum(memberNum);
    }
}
