package RollingRolling.RollingMindBackend.controller.create;

import RollingRolling.RollingMindBackend.dto.create.AddCreateRequest;
import RollingRolling.RollingMindBackend.service.create.CreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/create")
public class CreateController {
    private final CreateService createService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody AddCreateRequest request){
        AddCreateRequest addCreateRequest = createService.saveRoomAndPostIt(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCreateRequest);
    }

    @GetMapping
    public ResponseEntity<?> createInviteCode(){
        String invite_code = createService.generateInviteCode();
        return ResponseEntity.ok().body(Map.of("invite_code", invite_code));
    }

}