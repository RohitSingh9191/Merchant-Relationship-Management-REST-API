package com.merchant.Utils;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailSenderClass {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendMailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException ,NullPointerException {

        try{
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("rohit2154045@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);
        FileSystemResource file= new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(file.getFilename(),file);

            javaMailSender.send(mimeMessage);
        }
        catch(MessagingException ex){
            throw new RuntimeException(ex);
        }
        System.out.printf("Mail with attachment sent successfully..");

    }
}
