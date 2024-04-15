package RollingRolling.RollingMindBackend.service.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import RollingRolling.RollingMindBackend.dto.participant.AddParticipantRequest;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.ParticipantNotFoundException;
import RollingRolling.RollingMindBackend.repository.participant.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Transactional
    public Participant save(AddParticipantRequest request){  //방 참가자 테이블에 저장
        Participant participant = Participant.builder()
                .roomId(request.getRoom_id())
                .userId(request.getUser_id())
                .status(request.getStatus())
                .build();

        return participantRepository.save(participant);
    }

    public Participant updateStatus(Long id, ParticipantStatus status){  //참가자 참여요청 상태 업데이트
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(ErrorCode.PARTICIPANT_NOT_FOUND));
        participant.update(status);

        return participantRepository.save(participant);
    }

    public List<Participant> findAllByRoomId(String room_id){
        return participantRepository.findAllByRoomId(room_id);
    }

    public void delete(Long id){
        participantRepository.deleteById(id);
    }
}
