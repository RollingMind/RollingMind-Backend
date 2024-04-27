package RollingRolling.RollingMindBackend.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
public class AbstractValidator<T> implements Validator {

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public void validate(Object target, Errors errors) {
        try{
            doValidate((T) target, errors);
        } catch (RuntimeException e) {
            log.error("중복 검증 에러", e);
            throw e;
        }
    }

    //유효성 검증 로직
    protected void doValidate(final T dto, final Errors errors) {

    }
}
