package RollingRolling.RollingMindBackend.controller.hotrollingpaper;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.participant.AddParticipantRequest;
import RollingRolling.RollingMindBackend.dto.room.RoomResponse;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.RoomNotFoundException;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import RollingRolling.RollingMindBackend.service.hotrollingpaper.HotRollingPaperService;
import RollingRolling.RollingMindBackend.service.participant.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hot")
public class HotRollingPaperController {
    private final HotRollingPaperService hotRollingPaperService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> findHotRollingPaper(){  //지금 핫한 롤링페이퍼 목록 조회
        return ResponseEntity.ok().body(hotRollingPaperService.findAllRoomsOrderByParticipantsDesc());
    }
    @GetMapping("/search")
    public ResponseEntity<List<Room>> searchRooms(@RequestParam("keyword") String keyword) throws RoomNotFoundException {  //롤링페이퍼 방 검색
        List<Room> rooms = hotRollingPaperService.searchRoomsByTitle(keyword);
        if(rooms.isEmpty()){  //검색결과가 없을 경우
            throw new RoomNotFoundException(ErrorCode.ROOM_NOT_FOUND);
        }
        return ResponseEntity.ok().body(rooms);
    }
}
