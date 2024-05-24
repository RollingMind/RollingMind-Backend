package RollingRolling.RollingMindBackend.repository.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.domain.Template.TemplateLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemplateLikesRepository extends JpaRepository<TemplateLikes, Long> {
    @Query("SELECT tl.templateId FROM TemplateLikes tl WHERE tl.id = :id")
    List<Long> findTemplateIdsByMemberNum(@Param("id") int id);
}