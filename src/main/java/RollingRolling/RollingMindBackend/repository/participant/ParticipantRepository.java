package RollingRolling.RollingMindBackend.repository.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
