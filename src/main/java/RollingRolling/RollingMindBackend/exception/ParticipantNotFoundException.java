package RollingRolling.RollingMindBackend.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParticipantNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
}
