package RollingRolling.RollingMindBackend.repository.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostItRepository extends JpaRepository<PostIt, String> {
}
