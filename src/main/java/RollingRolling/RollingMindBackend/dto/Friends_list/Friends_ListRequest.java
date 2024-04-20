package RollingRolling.RollingMindBackend.dto.Friends_list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Friends_ListRequest {
    private int to_user;
    private int from_user;
    private boolean are_we_friend;
}
