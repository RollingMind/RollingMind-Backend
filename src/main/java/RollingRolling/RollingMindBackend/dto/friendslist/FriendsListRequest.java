package RollingRolling.RollingMindBackend.dto.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FriendsListRequest {
    private int toUser;
    private int fromUser;
    private FriendsListSituation situation;
}
