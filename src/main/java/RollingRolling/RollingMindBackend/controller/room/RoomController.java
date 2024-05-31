package RollingRolling.RollingMindBackend.controller.room;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.dto.room.AddRoomRequest;
import RollingRolling.RollingMindBackend.dto.room.RoomResponse;
import RollingRolling.RollingMindBackend.exception.BadRequestException;
import RollingRolling.RollingMindBackend.exception.PastReleaseDateException;
import RollingRolling.RollingMindBackend.exception.RoomNotFoundException;
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

    @PostMapping("/create")  //방 생성
    public ResponseEntity<?> createRoom(@RequestBody AddRoomRequest request) throws PastReleaseDateException {
        AddRoomRequest addCreateRequest = roomService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCreateRequest);
    }

    @GetMapping("/create")  //초대코드 생성
    public ResponseEntity<?> createInviteCode(){
        String invite_code = roomService.generateInviteCode();
        return ResponseEntity.ok().body(Map.of("invite_code", invite_code));
    }

    @GetMapping("/{id}/rollingpapers")  //내 롤링페이퍼 보관함 조회
    public ResponseEntity<List<Room>> getMyRollingPapers(@PathVariable("id") int id) throws RoomNotFoundException {
        return ResponseEntity.ok().body(roomService.findMyRollingPapers(id));
    }

    @GetMapping("/room/{roomId}")  //방 조회
    public ResponseEntity<RoomResponse> getRoom(@PathVariable("roomId") String roomId) throws RoomNotFoundException {
        return ResponseEntity.ok().body(roomService.getRoom(roomId));
    }

    @DeleteMapping("/room/{roomId}")  //방 삭제
    public ResponseEntity<?> delete(@PathVariable("roomId") String roomId) throws RoomNotFoundException, BadRequestException {
        roomService.delete(roomId);
        return ResponseEntity.ok().build();
    }
}