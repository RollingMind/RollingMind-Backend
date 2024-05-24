package RollingRolling.RollingMindBackend.repository.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findAllByRoomIdAndStatus(String roomId, ParticipantStatus participantStatus);
    @Query("SELECT p.roomId FROM Participant p WHERE p.id = :id AND p.status = :participantStatus")
    List<String> findRoomIdByIdAndStatus(@Param("id") int id, @Param("participantStatus") ParticipantStatus participantStatus);

    Optional<Participant> findByIdx(Long idx);
}
