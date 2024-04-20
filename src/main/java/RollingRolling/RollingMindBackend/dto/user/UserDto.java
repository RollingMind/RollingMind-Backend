package RollingRolling.RollingMindBackend.dto.user;

import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private long id;
    private int memberNum;

    @NotBlank(message = "아이디를 입력해 주세요.")
    @Size(min = 2, max = 10, message = "아이디는 2자 이상 10자 이하로 입력해 주세요")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Size(min = 4, max = 10, message = "비밀번호는 4자 이상 10자 이하로 입력해 주세요.")
    private String password;

    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;

    @NotBlank(message = "닉네임을 입력해 주세요.")
    @Size(min = 1, max = 5, message = "닉네임은 1자 이상 5자 이하로 입력해 주세요.")
    private String nickname;

    @NotBlank(message = "이메일을 입력해 주세요.")
    @Email(message = "올바른 이메일을 입력해 주세요.")
    private String email;

    @CreationTimestamp
    private String createdDate;

    private Login login;


}
