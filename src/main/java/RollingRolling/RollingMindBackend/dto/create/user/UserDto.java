package RollingRolling.RollingMindBackend.dto.create.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private int member_num;
    private String user_id;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String created_date;
}
