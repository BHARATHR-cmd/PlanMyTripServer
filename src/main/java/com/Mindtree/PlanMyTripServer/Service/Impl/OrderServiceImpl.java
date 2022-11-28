package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.OrderEntity;
import com.Mindtree.PlanMyTripServer.Repository.OrderRepository;
import com.Mindtree.PlanMyTripServer.Repository.PackageeRepository;
import com.Mindtree.PlanMyTripServer.Repository.UserRepository;
import com.Mindtree.PlanMyTripServer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageeRepository packageeRepository;

    @Override
    public OrderEntity createOrder(OrderEntity order) throws MessagingException {

       OrderEntity local =this.orderRepository.save(order);
       sendmail(order);
       return local;
    }

    public void sendmail(OrderEntity order) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                true);
        System.out.println(userRepository.findById(order.getUser().getUserid()).get().getEmailId());
        mimeMessageHelper.setTo(userRepository.findById(order.getUser().getUserid()).get().getEmailId());
        mimeMessageHelper.setSubject("Your Order was Successfull");

        String html = "<h3>Dear "+userRepository.findById(order.getUser().getUserid()).get().getName()+"</h3></br>"
                + "<p>Order Details : </p>"
                + "<p>"+"Price of the Order is :"+order.getOprice()+"<p>" + "</br></br>"
                + "<p>"+"Price of the Order is :"+packageeRepository.findById((long) order.getPackageid()).get().getPtilte()+"<p>" +
                "</br></br>"
                + "<p>"+"Price of the Order is :"+packageeRepository.findById((long) order.getPackageid()).get().getPdescription()+"<p>"
                + "</br></br>"
                + "<div style={max-width: 100px;max-height: 100px;min-width: 100px;min-height: 100px;}><img src=\""+packageeRepository.findById((long) order.getPackageid()).get().getPimage()+"\""+"<div> <h5>with Regards</h5>\n" +
                "<h5>Plan My Trip Customer Satisfaction Team </h5></div>";
        mimeMessageHelper.setText(html, true);

        javaMailSender.send(mimeMessage);
        System.out.println("mail Sent");

    }

    @Override
    public OrderEntity updateOrder(OrderEntity updateorder) {
        return this.orderRepository.save(updateorder);
    }

    @Override
    public OrderEntity getOrder(long oid) {
        return this.orderRepository.findById(oid).get();
    }

    @Override
    public List<OrderEntity> getOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public void deleteOrder(long oid) {
        this.orderRepository.deleteById(oid);
    }
}
