package RollingRolling.RollingMindBackend.repository.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.dto.Template.TemplateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    @Query("SELECT t FROM Template t WHERE t.templateId IN :templateIds")
    List<TemplateResponse> findByTemplateIds(List<Long> templateIds);
}