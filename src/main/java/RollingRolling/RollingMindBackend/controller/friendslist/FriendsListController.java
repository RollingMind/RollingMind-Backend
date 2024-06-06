package RollingRolling.RollingMindBackend.controller.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsList;
import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.friendslist.FriendsListRequest;
import RollingRolling.RollingMindBackend.dto.friendslist.FriendsListSituationUpdateRequest;
import RollingRolling.RollingMindBackend.repository.friendslist.FriendsListRepository;
import RollingRolling.RollingMindBackend.service.friendslist.FriendsListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/friends")
public class FriendsListController {
    private final FriendsListService friendsListService;

    @GetMapping("/{id}")  //친구 목록 조회
    public ResponseEntity<List<User>> findFriendsList(@PathVariable("id") int id){
        List<User> friendsList = friendsListService.findFriendsList(id);
        return ResponseEntity.ok().body(friendsList);
    }

    @PostMapping("/add") //친구 추가 요청
    public ResponseEntity<?> add(@RequestBody FriendsList Request) {
        FriendsList friendsList = friendsListService.add(Request);
        return ResponseEntity.status(HttpStatus.CREATED).body(friendsList);
    }

    @PatchMapping("/accept/{fromUser}")  // 친구 추가 수락
    public ResponseEntity<?> accept(@PathVariable("fromUser") int fromUser, @RequestBody FriendsListSituationUpdateRequest friendsListSituation){
        FriendsList friendsList = friendsListService.update(fromUser, friendsListSituation.getSituation());
        return ResponseEntity.ok().body(friendsList);
    }
}
