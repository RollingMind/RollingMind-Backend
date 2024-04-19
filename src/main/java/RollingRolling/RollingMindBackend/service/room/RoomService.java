package RollingRolling.RollingMindBackend.service.room;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.AddRoomRequest;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.PastReleaseDateException;
import RollingRolling.RollingMindBackend.repository.postit.PostItRepository;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public AddRoomRequest save(AddRoomRequest request){  //방 테이블에 저장
        //공개 날짜 체크
        if(request.getRelease_date() != null){
            LocalDateTime release_date = LocalDateTime.parse(String.valueOf(request.getRelease_date()));
            if(release_date.isBefore(LocalDateTime.now())){
                throw new PastReleaseDateException(ErrorCode.PAST_DATE_SELECTED);
            }
        }

        Room room = Room.builder()
                .roomId(request.getRoom_id())
                .hostId(request.getHost_id())
                .open(request.getOpen())
                .participation_request(request.getParticipation_request())
                .title(request.getTitle())
                .release_date(request.getRelease_date())
                .template_type(request.getTemplate_type())
                .build();
        roomRepository.save(room);

        return request;
    }

    public String generateInviteCode(){  //방 초대코드 랜덤생성 메서드
        String invite_code;
        do {
            invite_code = "3" + RandomStringUtils.randomNumeric(5);  //3XXXXX 초대코드(방 아이디) 생성
        }while (roomRepository.existsByRoomId(invite_code));
        return invite_code;
    }
}
