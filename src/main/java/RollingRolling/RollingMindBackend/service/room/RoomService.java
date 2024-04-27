package RollingRolling.RollingMindBackend.service.room;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.AddRoomRequest;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.ParticipantNotFoundException;
import RollingRolling.RollingMindBackend.exception.PastReleaseDateException;
import RollingRolling.RollingMindBackend.exception.RoomNotFoundException;
import RollingRolling.RollingMindBackend.repository.participant.ParticipantRepository;
import RollingRolling.RollingMindBackend.repository.postit.PostItRepository;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final ParticipantRepository participantRepository;

    @Transactional
    public AddRoomRequest save(AddRoomRequest request){
        //공개 날짜 체크
        if(request.getReleaseDate() != null){
            LocalDateTime release_date = LocalDateTime.parse(String.valueOf(request.getReleaseDate()));
            if(release_date.isBefore(LocalDateTime.now())){
                throw new PastReleaseDateException(ErrorCode.PAST_DATE_SELECTED);
            }
        }

        Room room = Room.builder()  //방 저장
                .roomId(request.getRoomId())
                .hostId(request.getHostId())
                .open(request.getOpen())
                .participationRequest(request.getParticipationRequest())
                .title(request.getTitle())
                .releaseDate(request.getReleaseDate())
                .templateType(request.getTemplateType())
                .templateId(request.getTemplateId())
                .build();
        roomRepository.save(room);

        request.getParticipantList().forEach(memberNum -> {  //참가자 저장
            Participant participant = Participant.builder()
                    .roomId(request.getRoomId())
                    .memberNum(memberNum)
                    .status(ParticipantStatus.ACCEPT)
                    .build();
            participantRepository.save(participant);
        });

        return request;
    }

    public String generateInviteCode(){  //방 초대코드 랜덤생성 메서드
        String invite_code;
        do {
            invite_code = "3" + RandomStringUtils.randomNumeric(5);  //3XXXXX 초대코드(방 아이디) 생성
        }while (roomRepository.existsByRoomId(invite_code));
        return invite_code;
    }

    public List<Room> findMyRollingPapers(int memberNum){  //내 롤링페이퍼 목록 조회
        List<String> roomIdList = participantRepository.findRoomIdByMemberNumAndStatus(memberNum, ParticipantStatus.ACCEPT);  //memberNum이 참가한 방 아이디 리스트
        List<Room> roomList1 = roomRepository.findAllByRoomIdIn(roomIdList);  //참가한 방 리스트
        List<Room> roomList2 = roomRepository.findAllByHostId(memberNum);  //방장인 방 리스트
        roomList1.addAll(roomList2);

        if(roomList1.isEmpty()){  //없는 경우
            throw new RoomNotFoundException(ErrorCode.ROOM_NOT_FOUND);
        }
        return roomList1;
    }
}
