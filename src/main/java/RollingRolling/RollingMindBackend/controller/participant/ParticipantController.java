package RollingRolling.RollingMindBackend.controller.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.dto.participant.AddParticipantRequest;
import RollingRolling.RollingMindBackend.service.participant.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/participant")
public class ParticipantController {
    private final ParticipantService participantService;
    @PostMapping
    public ResponseEntity<Participant> addParticipant(@RequestBody AddParticipantRequest request){
        Participant addParticipantRequest = participantService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addParticipantRequest);
    }
}
