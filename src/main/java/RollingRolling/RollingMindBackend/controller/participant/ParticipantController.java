package RollingRolling.RollingMindBackend.controller.participant;

import RollingRolling.RollingMindBackend.domain.participant.Participant;
import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import RollingRolling.RollingMindBackend.dto.participant.AddParticipantRequest;
import RollingRolling.RollingMindBackend.service.participant.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{room_id}")
    public ResponseEntity<List<Participant>> findParticipant(@PathVariable String room_id){
        return ResponseEntity.ok().body(participantService.findAllByRoomId(room_id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id){
        participantService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipantStatus(@PathVariable Long id, @RequestBody Participant p){
        Participant participant = participantService.updateStatus(id, p.getStatus());
        return ResponseEntity.ok().body(participant);
    }
}
