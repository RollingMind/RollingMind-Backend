package RollingRolling.RollingMindBackend.repository.room;

import RollingRolling.RollingMindBackend.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomId(String roomId);
}
