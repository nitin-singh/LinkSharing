package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by Prashant on 19-Jul-17.
 */
@Component
public class TopicService {
    String messageUser="Email not sent";

    @Autowired
    private JavaMailSender mailSender;

    public String sendInvite(String email,String topic){

        String msg = "<html>" + "<head>" + "</head>" + "<body>" +
                "Hi " +
                ",<br><br>You are Invited To subscribe following Topic."+topic+"<br><br>Please Follow the link to Subscribe the topic<b></b><br>" +
                "<a href='http://localhost:8080/'>Click Here to Register First</a><br><br>Thanks<br>LinkSharing"+
                "</body>" + "</html>";
        String recipientAddress = email;
        String subject = "Invitation";

        mailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setFrom("linksharing17@gmail.com");
                message.setTo(email);
                message.setSubject(subject);
                message.setText(msg, true);
                messageUser = "Email Sent";
            }
        });


        return messageUser;



    }

    public String uploadFile(String appPath,MultipartFile file){
        System.out.println(appPath);

        String filePath=null;
        try {
            System.out.println(appPath);
            String dest = appPath+"/uploads/";
            if(! new File(dest).exists())
            {
                new File(dest).mkdir();
            }
             filePath = dest + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            System.out.println("done");
        }
        catch (Exception e){
            e.getMessage();
        }

return filePath;
    }



}
