package RollingRolling.RollingMindBackend.repository.template;

import RollingRolling.RollingMindBackend.domain.Template.Template;
import RollingRolling.RollingMindBackend.domain.Template.TemplateLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemplateLikesRepository extends JpaRepository<TemplateLikes, Long> {
    @Query("SELECT tl.template FROM TemplateLikes tl WHERE tl.memberNum = :memberNum")
    List<Template> findTemplatesByMemberNum(int memberNum);
}
