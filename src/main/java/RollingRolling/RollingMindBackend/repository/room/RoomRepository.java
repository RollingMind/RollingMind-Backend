package RollingRolling.RollingMindBackend.repository.room;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.RoomResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomId(String roomId);
    @Query("SELECT r, COUNT(p) FROM Room r LEFT JOIN Participant p ON r.roomId = p.roomId GROUP BY r.roomId ORDER BY COUNT(p) DESC")
    List<Object[]> findAllRoomsWithParticipantsCount();
    List<Room> findAllByHostId(int memberNum);
    List<Room> findAllByRoomIdIn(List<String> roomIds);
    List<Room> findByTitleContaining(String keyword);

    @Query("SELECT r, COUNT(p) FROM Room r LEFT JOIN Participant p ON r.roomId = p.roomId WHERE r.roomId = :roomId GROUP BY r.roomId ORDER BY COUNT(p) DESC")
    List<Object[]> findByRoomId(String roomId);
}
