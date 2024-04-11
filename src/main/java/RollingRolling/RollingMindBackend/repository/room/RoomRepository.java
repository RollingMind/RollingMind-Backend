package RollingRolling.RollingMindBackend.repository;

import RollingRolling.RollingMindBackend.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
    boolean existsById(String id);
}
