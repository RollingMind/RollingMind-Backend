package RollingRolling.RollingMindBackend.repository.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.Template.TemplateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    @Query("SELECT t FROM Template t WHERE t.templateId IN :templateIds")
    List<TemplateResponse> findByTemplateIds(@Param("templateIds") List<Long> templateIds);
    List<Template> findByHashtagContaining(String keyword);
    Optional<Template> findByTemplateId(int templateId);
    @Query("SELECT t.templateId AS templateId, t.optionValue AS optionValue " +
            "FROM Template t LEFT JOIN TemplateLikes l ON t.templateId = l.templateId " +
            "GROUP BY t.templateId ORDER BY COUNT(l.templateId) DESC")
    List<TemplateResponse> findTemplatesOrderByLikesCount();
}