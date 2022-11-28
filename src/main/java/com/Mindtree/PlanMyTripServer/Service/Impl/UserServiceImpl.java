package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import com.Mindtree.PlanMyTripServer.Repository.UserRepository;
import com.Mindtree.PlanMyTripServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;



    @Override
    public UserEntity createUser(UserEntity user) throws Exception {
        UserEntity local = this.userRepository.findByEmailId(user.getEmailId());
        if(local!=null){
            System.out.println("User Already Exits!!!!");
            throw new Exception("User Aleady Present");
        }
            user.setUsername("Default_00000");
            userRepository.save(user);
            user.setUsername(user.getName().toLowerCase()+user.getUserid()+"@planmytrip.com");
            local=userRepository.save(user);
            sendmail(local.getName(),local.getEmailId(),local.getUsername());

            return local;

    }
    public void sendmail(String name,String mail,String username) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                true);

        mimeMessageHelper.setTo(mail);
        mimeMessageHelper.setSubject("Welcome Plan My Trip Family!!");

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <!-- CSS only -->\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\"position-relative\">\n" +
                "        <div class=\"position-absolute top-0 start-0\">\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"row \">\n" +
                "                    <div class=\"col \">\n" +
                "                        <h6>Dear "+name+",</h6> <br>\n" +
                "                        <h4>Login Using ::</h4><br>\n" +
                "                        <h5>UserName :: "+username+"</h5><br>\n" +
                "                    </div>\n" +
                "                    <div class=\"col card mt-4\">\n" +
                "                        <img src=\"https://t4.ftcdn.net/jpg/03/25/27/91/360_F_325279131_DG1NddUt5VMsFvVdUbe1SaeEZ74fZzac.jpg\" class=\"img-fluid\" alt=\"Welcome to family\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <h5>with Regards</h5>\n" +
                "                    <h5>Plan My Trip Customer Satisfaction Team </h5>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        mimeMessageHelper.setText(html, true);
        try{
            javaMailSender.send(mimeMessage);
        }catch (MailSendException e){
            System.out.println(e);
        }

        System.out.println("mail Sent");

    }

    @Override
    public UserEntity getUser(String username) {
        UserEntity local=this.userRepository.findByUsername(username);
        return local;
    }

    @Override
    public UserEntity updateUser(UserEntity user) throws MessagingException {
        user.setUsername(user.getName().toLowerCase(Locale.ROOT)+user.getUserid()+"@planmytrip.com");
        UserEntity local = userRepository.save(user);
        sendmail(local.getName(),local.getEmailId(),local.getUsername());
        return local;
    }


    @Override
    public void deleteUser(Long userid) {
        this.userRepository.deleteById(userid);
    }


}
