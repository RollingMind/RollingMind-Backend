package RollingRolling.RollingMindBackend.repository.room;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomId(String roomId);
    @Query("SELECT r FROM Room r LEFT JOIN r.participantList p GROUP BY r.id ORDER BY COUNT(p) DESC")
    List<Room> findAllRoomsOrderByParticipantsDesc();
}
