package RollingRolling.RollingMindBackend.service.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsList;
import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
import RollingRolling.RollingMindBackend.domain.postit.PostIt;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.dto.friendslist.FriendsListSituationUpdateRequest;
import RollingRolling.RollingMindBackend.dto.postit.PostItUpdateRequest;
import RollingRolling.RollingMindBackend.repository.friendslist.FriendsListRepository;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FriendsListService {
    private final FriendsListRepository friendsListRepository;
    private final UserRepository userRepository;

    public List<User> findFriendsList(int id){  //친구 목록 조회
        List<Integer> friendsIdList = friendsListRepository.findFromUserByToUserAndSituation(id, FriendsListSituation.FRIEND);  //situation이 FRIEND인 fromUser 가져옴

        return userRepository.findAllByIdIn(friendsIdList);
    }


    public FriendsList add(FriendsList Request){   //친구 신청
        FriendsList friendsList = FriendsList.builder()
                .toUser(Request.getToUser())
                .fromUser(Request.getFromUser())
                .situation(FriendsListSituation.REQUEST)
                .build();
        friendsListRepository.save(friendsList);

        return friendsList;
    }

    public FriendsList update(int fromUser, FriendsListSituation friendsListSituation){  //친구 수락
        FriendsList friendsList = friendsListRepository.findByFromUser(fromUser)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. id: " + fromUser));

        friendsList.update(friendsListSituation);
        friendsListRepository.save(friendsList);
        return friendsList;
    }

}
