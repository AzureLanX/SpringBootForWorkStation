package com.blue.utils;

import com.blue.constant.EmailConstant;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.utils
 * @Author: JuferBlue
 * @CreateTime: 2025-01-06  21:16
 * @Description: TODO
 * @Version: 1.0
 */
@CommonsLog
@Component
public class SendEmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

    public String sendEmail(String userEmail) {
        // 创建一个简单的邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username); // 发件人邮箱，需和配置的用户名一致
        message.setTo(userEmail); // 收件人邮箱
        message.setSubject(EmailConstant.EMAIL_SUBJECT); // 邮件主题
        String code = generateFormattedCode();
        message.setText(EmailConstant.EMAIL_CONTENT+code); // 邮件内容
        // 发送邮件
        javaMailSender.send(message);
        // 简单提示
        return code;
    }
    private String generateFormattedCode() {
        Random random = new Random();
        int code = random.nextInt(1000000); // 生成0到999999之间的随机数
        return String.format("%06d", code); // 格式化为6位数，不足前面补0
    }
}
