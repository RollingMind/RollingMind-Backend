package RollingRolling.RollingMindBackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorDTO {
    private final int status;
    private final String message;

    public ErrorDTO(ErrorCode errorCode){
        this.status = errorCode.getStatus().value();
        this.message = errorCode.getMessage();
    }
}
