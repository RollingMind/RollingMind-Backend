package RollingRolling.RollingMindBackend.service.email;

import RollingRolling.RollingMindBackend.dto.email.EmailCheckRequest;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender emailSender;
    public static HashMap<String, String> codeStorage = new HashMap<>();

    public static final String ePw = createKey();

    private MimeMessage createMessage(String to)throws Exception{
        System.out.println("받는 대상 : "+ to);
        System.out.println("인증 번호 : "+ePw);
        codeStorage.put(to, ePw);
        MimeMessage  message = emailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, to);//받는 대상
        message.setSubject("롤링마인드 이메일 인증");//제목

        String msgg="";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>인증 번호입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "CODE : <strong>";
        msgg+= ePw+"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("ganghyorim@gmail.com","RollingMind"));//보내는 사람

        return message;
    }

    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 6자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    @Override
    public String sendSimpleMessage(String to)throws Exception {
        // TODO Auto-generated method stub
        MimeMessage message = createMessage(to);
        try{//예외처리
            emailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return ePw;
    }

    @Override
    public boolean confirmEmail(EmailCheckRequest request){
        String email = request.getEmail();
        String code = request.getCode();
        String findCode = codeStorage.get(email);
        if (code.equals(findCode)) {
            System.out.println("일치");
            codeStorage.remove(email);
            return true;
        }
        System.out.println("불일치");
        return false;
    }
}
