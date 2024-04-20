package RollingRolling.RollingMindBackend.controller.postit;

import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.service.postit.PostItService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
