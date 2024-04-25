package RollingRolling.RollingMindBackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RoomNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;
}
