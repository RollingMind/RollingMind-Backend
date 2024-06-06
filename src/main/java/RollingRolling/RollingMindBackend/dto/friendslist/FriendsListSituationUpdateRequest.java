package RollingRolling.RollingMindBackend.dto.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendsListSituationUpdateRequest {
    private FriendsListSituation situation;
}
