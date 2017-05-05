package mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by p on 2017/5/5.
 */
public class ActiveAcountMailer {

    @Autowired
    private JavaMailSenderImpl sender;
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void send(String toEmail, String token) throws MessagingException {
        MimeMessage message= sender.createMimeMessage();
        //使用MimeMessageHelper构建Mime类型邮件
        MimeMessageHelper helper= new MimeMessageHelper(message,true);
        helper.setFrom("bevanpf@163.com");
        helper.setTo(toEmail);
        message.setSubject("账号激活");
        //第二个参数true表明信息类型是multipart类型
        //helper.setText("<body>点击以下链接激活您的账户<a href=\"http://localhost:8080/resetpwd?email="+toEmail+"&token="+token+ "\">链接</a></body>",true);
        helper.setText("<body>点击这个链接激活您的账户<a href=\"http://"+host+"/active?email="+toEmail+"&token="+token+"\">链接</a></body>",true);
        sender.send(message);
    }
}
