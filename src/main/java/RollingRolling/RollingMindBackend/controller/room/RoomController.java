package RollingRolling.RollingMindBackend.controller.room;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.domain.user.CustomUserDetails;
import RollingRolling.RollingMindBackend.dto.room.AddRoomRequest;
import RollingRolling.RollingMindBackend.dto.room.RoomResponse;
import RollingRolling.RollingMindBackend.exception.BadRequestException;
import RollingRolling.RollingMindBackend.exception.ErrorCode;
import RollingRolling.RollingMindBackend.exception.PastReleaseDateException;
import RollingRolling.RollingMindBackend.exception.RoomNotFoundException;
import RollingRolling.RollingMindBackend.repository.postit.PostItRepository;
import RollingRolling.RollingMindBackend.repository.room.RoomRepository;
import RollingRolling.RollingMindBackend.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody AddRoomRequest request) throws PastReleaseDateException {  //방 생성
        AddRoomRequest addCreateRequest = roomService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCreateRequest);
    }

    @GetMapping("/create")
    public ResponseEntity<?> createInviteCode(){  //초대코드
        String invite_code = roomService.generateInviteCode();
        return ResponseEntity.ok().body(Map.of("invite_code", invite_code));
    }

    @GetMapping("/{id}/rollingpapers")
    public ResponseEntity<List<Room>> getMyRollingPapers(@PathVariable("id") int id) throws RoomNotFoundException {  //내 롤링페이퍼 보관함
        return ResponseEntity.ok().body(roomService.findMyRollingPapers(id));
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<RoomResponse> getRoom(@PathVariable("roomId") String roomId) throws RoomNotFoundException {
        return ResponseEntity.ok().body(roomService.getRoom(roomId));
    }

    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<?> delete(@PathVariable("roomId") String roomId) throws RoomNotFoundException, BadRequestException {
        roomService.delete(roomId);
        return ResponseEntity.ok().build();
    }
}