package RollingRolling.RollingMindBackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PastReleaseDateException extends RuntimeException {
    private final ErrorCode errorCode;
}
