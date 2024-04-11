package RollingRolling.RollingMindBackend.service.create;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.create.AddCreateRequest;
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
public class CreateService {
    private final RoomRepository roomRepository;
    private final PostItRepository postItRepository;
    @Transactional
    public AddCreateRequest saveRoomAndPostIt(AddCreateRequest request){
        //공개 날짜 체크
        if(request.getRelease_date() != null){
            LocalDateTime release_date = LocalDateTime.parse(String.valueOf(request.getRelease_date()));
            if(release_date.isBefore(LocalDateTime.now())){
                throw new PastReleaseDateException(ErrorCode.PAST_DATE_SELECTED);
            }
        }

        Room room = Room.builder()
                .room_id(request.getRoom_id())
                .host_id(request.getHost_id())
                .open(request.getOpen())
                .participation_request(request.getParticipation_request())
                .build();
        roomRepository.save(room);

        PostIt postIt = PostIt.builder()
                .room_id(request.getRoom_id())
                .title(request.getTitle())
                .release_date(request.getRelease_date())
                .content(request.getContent())
                .template(request.getTemplate())
                .build();
        postItRepository.save(postIt);

        return request;
    }

    public String generateInviteCode(){
        String invite_code;
        do {
            invite_code = "3" + RandomStringUtils.randomNumeric(5);  //3XXXXX 초대코드(방 아이디) 생성
        }while (roomRepository.existsById(invite_code));
        return invite_code;
    }
}
