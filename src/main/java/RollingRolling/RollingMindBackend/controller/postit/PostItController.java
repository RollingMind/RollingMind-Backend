package RollingRolling.RollingMindBackend.controller.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.domain.user.CustomUserDetails;
import RollingRolling.RollingMindBackend.dto.postit.PostItRequest;
import RollingRolling.RollingMindBackend.dto.postit.PostItUpdateRequest;
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

    @GetMapping("/{roomId}")  //room_id인 post_it 목록 조회
    public ResponseEntity<List<PostIt>> findPostItList(@PathVariable("roomId") String roomId){
        List<PostIt> postItList = postItService.findByRoomId(roomId);
        return ResponseEntity.ok().body(postItList);
    }

    @PostMapping("/{roomId}")  //포스트잇 작성
    public ResponseEntity<PostItRequest> savePostIt(@RequestBody PostItRequest postItRequest){
        PostItRequest postIt = postItService.save(postItRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(postIt);
    }

    @DeleteMapping("/delete/{postItId}")  //포스트잇 삭제
    public ResponseEntity<?> deletePostIt(@PathVariable("postItId") Long postItId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails currentUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String currentUserNickName = currentUserDetails.getNickname();
        postItService.delete(postItId, currentUserNickName);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{postItId}")  //포스트잇 수정
    public ResponseEntity<PostIt> updatePostIt(@PathVariable("postItId") Long postItId, @RequestBody PostItUpdateRequest postItUpdateRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails currentUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String currentUserNickName = currentUserDetails.getNickname();
        PostIt postIt = postItService.update(postItId, currentUserNickName, postItUpdateRequest);
        return ResponseEntity.ok().body(postIt);
    }
}
