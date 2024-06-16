package RollingRolling.RollingMindBackend.controller.hotrollingpaper;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.HotRollingPaperResponse;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.RoomNotFoundException;
import RollingRolling.RollingMindBackend.service.hotrollingpaper.HotRollingPaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hot")
public class HotRollingPaperController {
    private final HotRollingPaperService hotRollingPaperService;

    @GetMapping
    public ResponseEntity<List<HotRollingPaperResponse>> findHotRollingPaper(){  //지금 핫한 롤링페이퍼 목록 조회
        return ResponseEntity.ok().body(hotRollingPaperService.findHotRollingPaper());
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
