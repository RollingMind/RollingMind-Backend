package RollingRolling.RollingMindBackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    //잘못된 요청
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),
    // 지난 날짜 선택
    PAST_DATE_SELECTED(HttpStatus.BAD_REQUEST, "지난 날짜를 선택할 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
