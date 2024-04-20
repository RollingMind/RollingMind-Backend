package RollingRolling.RollingMindBackend.controller.hotrollingpaper;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.service.hotrollingpaper.HotRollingPaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hot")
public class HotRollingPaperController {
    private final HotRollingPaperService hotRollingPaperService;

    @GetMapping
    public ResponseEntity<List<Room>> findHotRollingPaper(){  //지금 핫한 롤링페이퍼 목록 조회
        return ResponseEntity.ok().body(hotRollingPaperService.findAllRoomsOrderByParticipantsDesc());
    }
}
