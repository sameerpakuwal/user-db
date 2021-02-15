package com.vastika.ud.controller;

import com.vastika.ud.model.User;
import com.vastika.ud.service.UserService;
import com.vastika.ud.util.PasswordCheck;
import com.vastika.ud.util.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordCheck passwordCheck;

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "forgot_password_form";
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = RandomString.make(30);

        try {
            userService.updateResetPassword(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            System.out.println(resetPasswordLink);
            sendEmail(email, resetPasswordLink);
            model.addAttribute("msg", "We have sent a reset password link to your email. Please check.");

        }catch (UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", "Error while sending email");
        }

        catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }

        return "forgot_password_form";
    }

    public void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        String subject = "Here is the link to reset your password";
        String content = "<p>Hello,Happy valentine day</p>"
                +"<p>You have requested to reset your password.</p>"
                +"<p>Click the link below.</p>"
                +"<p><b><a href = \""+resetPasswordLink+"\">Change my password</a></b></p>"
                +"<p>Ignore this email if you have not requested password reset link</p>";
        helper.setFrom("ilovemykalu@gmail.com","Sameer Pakuwal");
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(helper.getMimeMessage());
        // Transport.send(message);
    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model)
    //safasfas
    {
        String page = " ";
      User user = userService.getByResetPasswordToken(token);

        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            page = "forgot_password_form";
        }
        else{
            page = "reset_password_form";
            model.addAttribute("token", token);
        }
        return page;
    }

    @PostMapping("/reset_password")
    public String resetPassword(HttpServletRequest request,Model model) {
        String page ="";
        String token = request.getParameter("token");
        System.out.println(token);
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

       if( passwordCheck.checkPassword(password1) && (password1.equals(password2)))

        {
            User user = userService.getByResetPasswordToken(token);
            if (user != null) {
                userService.updatePassword(user, password1);
                model.addAttribute("message", "you have successfully changed your password");
                page = "login";
            } else {
                model.addAttribute("title", "Reset your password");
                model.addAttribute("invalid_token", "Invalid token");
                page = "reset_password_form";
            }

        }else {
            model.addAttribute("not_match", "Password do not match or crietria do not match");
            page ="reset_password_form";
        }
        return page;
    }

}
