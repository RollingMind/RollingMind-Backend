package RollingRolling.RollingMindBackend.repository.room;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.HotRollingPaperResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomId(String roomId);
    @Query(value = "SELECT r.idx AS idx, u.nickname AS nickname, u.image AS image, r.room_id AS roomId, r.open AS open, r.participation_request AS participationRequest, r.title AS title, r.content AS content, r.release_date AS releaseDate, r.template_type AS templateType, COUNT(p.room_id) AS participantsCount " +
        "FROM rooms r " +
        "LEFT JOIN participants p ON r.room_id = p.room_id " +
        "LEFT JOIN users u ON r.host_id = u.id " +
        "GROUP BY r.idx, u.nickname, u.image, r.room_id, r.open, r.participation_request, r.title, r.content, r.release_date, r.template_type " +
        "ORDER BY participantsCount DESC", nativeQuery = true)
    List<HotRollingPaperResponse> findAllRoomsWithParticipantsCount();
    List<Room> findAllByHostId(int memberNum);
    List<Room> findAllByRoomIdIn(List<String> roomIds);
    List<Room> findByTitleContaining(String keyword);

    @Query("SELECT r, COUNT(p) FROM Room r LEFT JOIN Participant p ON r.roomId = p.roomId WHERE r.roomId = :roomId GROUP BY r.roomId ORDER BY COUNT(p) DESC")
    List<Object[]> findRoomWithParticipantCountByRoomId(@Param("roomId")String roomId);

    Optional<Room> findByRoomId(String roomId);
}
