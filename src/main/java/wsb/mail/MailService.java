package wsb.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.nio.channels.ScatteringByteChannel;

@Service
@RequiredArgsConstructor
public class MailService {

    final private JavaMailSender javaMailSender;

    void sendMail(Mail mail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

            mimeMessageHelper.setTo(mail.recipient);
            mimeMessageHelper.setTo(mail.subject);
            mimeMessageHelper.setTo(mail.content);

            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Wysyłanie maila nie powiodło się");
        }
    }
}
