package RollingRolling.RollingMindBackend.service.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import RollingRolling.RollingMindBackend.dto.participant.AddParticipantRequest;
import RollingRolling.RollingMindBackend.repository.participant.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Transactional
    public Participant save(AddParticipantRequest request){  //방 참가자 테이블에 저장
        Participant participant = Participant.builder()
                .room_id(request.getRoom_id())
                .user_id(request.getUser_id())
                .status(request.getStatus())
                .build();

        return participantRepository.save(participant);
    }

    public void delete(Long id){
        participantRepository.deleteById(id);
    }
}
