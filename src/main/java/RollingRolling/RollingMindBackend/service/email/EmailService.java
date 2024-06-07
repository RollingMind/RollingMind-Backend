package RollingRolling.RollingMindBackend.service.email;

import RollingRolling.RollingMindBackend.dto.email.EmailCheckRequest;

public interface EmailService {
    String sendSimpleMessage(String to)throws Exception;
    boolean confirmEmail(EmailCheckRequest request);
}
