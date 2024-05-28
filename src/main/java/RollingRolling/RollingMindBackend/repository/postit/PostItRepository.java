package RollingRolling.RollingMindBackend.repository.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostItRepository extends JpaRepository<PostIt, Long> {
    List<PostIt> findByRoomId(String roomId);
    void deleteAllByRoomId(String roomId);

    boolean existsByRoomId(String roomId);
}
