package RollingRolling.RollingMindBackend.controller.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsList;
import RollingRolling.RollingMindBackend.domain.user.User;
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

    @GetMapping("/{id}")
    public ResponseEntity<List<User>> findFriendsList(@PathVariable("id") int id){  //친구 목록 조회
        List<User> friendsList = friendsListService.findFriendsList(id);
        return ResponseEntity.ok().body(friendsList);
    }

    @PostMapping("/addfriends")
    public ResponseEntity<?> add(@RequestBody FriendsList Request) {
        FriendsList friendsList = friendsListService.add(Request);
        return ResponseEntity.status(HttpStatus.CREATED).body(friendsList);
    }
}
