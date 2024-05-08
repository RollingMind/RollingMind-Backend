package RollingRolling.RollingMindBackend.controller.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.dto.postit.PostItRequest;
import RollingRolling.RollingMindBackend.service.postit.PostItService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/postit")
public class PostItController {
    private final PostItService postItService;

    @GetMapping("/{room_id}")  //room_id인 post_it 목록 조회
    public ResponseEntity<List<PostIt>> findPostItList(@PathVariable String room_id){
        List<PostIt> postItList = postItService.findByRoomId(room_id);
        return ResponseEntity.ok().body(postItList);
    }

    @PostMapping("/{room_id}")  //포스트잇 작성
    public ResponseEntity<PostItRequest> savePostIt(@RequestBody PostItRequest postItRequest){
        PostItRequest postIt = postItService.save(postItRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(postIt);
    }

    @DeleteMapping("/delete/{postItId}")  //포스트잇 삭제
    public ResponseEntity<?> deletePostIt(@PathVariable Long postItId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userNickname = authentication.getName();
        postItService.delete(postItId, userNickname);
        return ResponseEntity.ok().build();
    }
}
