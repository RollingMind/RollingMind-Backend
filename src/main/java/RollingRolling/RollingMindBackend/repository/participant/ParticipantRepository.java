package RollingRolling.RollingMindBackend.repository.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findAllByRoomIdAndStatus(String roomId, ParticipantStatus participantStatus);
    @Query("SELECT p.roomId FROM Participant p WHERE p.memberNum = :memberNum AND p.status = :participantStatus")
    List<String> findRoomIdByMemberNumAndStatus(int memberNum, ParticipantStatus participantStatus);
}
