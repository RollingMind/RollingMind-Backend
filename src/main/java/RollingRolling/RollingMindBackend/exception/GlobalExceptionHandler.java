package RollingRolling.RollingMindBackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({PastReleaseDateException.class})
    protected ResponseEntity handlePastReleaseDateException(PastReleaseDateException ex){
        return ResponseEntity
                .status(ErrorCode.PAST_DATE_SELECTED.getStatus().value())
                .body(new ErrorDTO(ErrorCode.PAST_DATE_SELECTED));
    }
}
