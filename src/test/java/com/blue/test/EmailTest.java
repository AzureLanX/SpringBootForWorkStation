package com.blue.test;

import com.blue.utils.SendEmailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.test
 * @Author: JuferBlue
 * @CreateTime: 2025-01-06  21:43
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class EmailTest {
    @Autowired
    private SendEmailUtil sendEmailUtil;
    @Autowired
    private JavaMailSender javaMailSender;
    @Test
    public void testSendEmail() {
        // 创建一个简单的邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("workstationverify@qq.com"); // 发件人邮箱，需和配置的用户名一致
        message.setTo("2846823009@qq.com"); // 收件人邮箱
        message.setSubject("Test Email"); // 邮件主题
        message.setText("This is a test email from Spring Boot!"); // 邮件内容

        // 发送邮件
        javaMailSender.send(message);

        // 简单提示
        System.out.println("Email sent successfully!");
    }

    @Test
    public void testEmailUtil() {
        String code = sendEmailUtil.sendEmail("2846823009@qq.com");
        System.out.println(code);
    }
}
