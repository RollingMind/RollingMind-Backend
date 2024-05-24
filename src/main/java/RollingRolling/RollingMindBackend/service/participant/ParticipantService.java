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
                .roomId(request.getRoomId())
                .id(request.getId())
                .status(request.getStatus())
                .build();

        return participantRepository.save(participant);
    }

    public Participant updateStatus(Long idx, ParticipantStatus status) throws ParticipantNotFoundException {  //참가자 참여요청 상태 업데이트
        Participant participant = participantRepository.findByIdx(idx)
                .orElseThrow(() -> new ParticipantNotFoundException(ErrorCode.PARTICIPANT_NOT_FOUND));
        System.out.println(participant.toString());
        participant.update(status);

        return participantRepository.save(participant);
    }

    public List<Participant> findAllByRoomIdAndStatus(String roomId){  //방 참가자 목록 조회
        return participantRepository.findAllByRoomIdAndStatus(roomId, ParticipantStatus.ACCEPT);
    }

    public void delete(Long idx) throws ParticipantNotFoundException {  //방 참가자 삭제
        if (participantRepository.existsById(idx)) {
            participantRepository.deleteById(idx);
        } else {
            throw new ParticipantNotFoundException(ErrorCode.PARTICIPANT_NOT_FOUND);
        }
    }
}
