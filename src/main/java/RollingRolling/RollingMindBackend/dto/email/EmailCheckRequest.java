package RollingRolling.RollingMindBackend.dto.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailCheckRequest {
    private String email;
    private String code;
}
