package RollingRolling.RollingMindBackend.controller.friendslist;

import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.repository.friendslist.FriendsListRepository;
import RollingRolling.RollingMindBackend.service.friendslist.FriendsListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/friends")
public class FriendsListController {
    private final FriendsListService friendsListService;

    @GetMapping("/{memberNum}")
    public ResponseEntity<List<User>> findFriendsList(@PathVariable("memberNum") int memberNum){  //친구 목록 조회
        List<User> friendsList = friendsListService.findFriendsList(memberNum);
        return ResponseEntity.ok().body(friendsList);
    }
}
