package mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by p on 2017/5/6.
 */
public class ResetPwdMailer {
    @Autowired
    private JavaMailSenderImpl sender;
    String host;

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
        message.setSubject("重置密码");
        //第二个参数true表明信息类型是multipart类型
        helper.setText("<body>点击以下链接重置<a href=\"http://"+host+ "/pwd/forgetLink.action?email="+toEmail+"&token="+token+ "\">链接</a></body>",true);
        sender.send(message);
    }
}
