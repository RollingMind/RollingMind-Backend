package RollingRolling.RollingMindBackend.controller.room;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.AddRoomRequest;
import RollingRolling.RollingMindBackend.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody AddRoomRequest request) {  //방 생성
        AddRoomRequest addCreateRequest = roomService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCreateRequest);
    }

    @GetMapping("/create")
    public ResponseEntity<?> createInviteCode(){  //초대코드
        String invite_code = roomService.generateInviteCode();
        return ResponseEntity.ok().body(Map.of("invite_code", invite_code));
    }

     @GetMapping("/{memberNum}/rollingpapers")
    public ResponseEntity<List<Room>> getMyRollingPapers(@PathVariable int memberNum){  //내 롤링페이퍼 보관함
         return ResponseEntity.ok().body(roomService.findMyRollingPapers(memberNum));
     }
}