package com.example_spring.spring.servingwebcontent;

import com.example_spring.spring.db.ConsumerEntity;
import com.example_spring.spring.db.OrdersEntity;
import com.example_spring.spring.db.SellerEntity;
import com.example_spring.spring.services.ConsumerService;
import com.example_spring.spring.services.OrderService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Controller
public class GreetingController {

    @Autowired

    private ConsumerService consumerService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        ConsumerEntity consumer = null;
        if (name != null) {
            try {
                int id = Integer.parseInt(name);
                consumer = consumerService.getConsumerById(id);
            } catch (NumberFormatException e) {
                // Если параметр не является числом, то обрабатываем его как имя пользователя
                model.addAttribute("name", name);
                return "greeting";
            }
        }
        if (consumer != null) {
            model.addAttribute("name", consumer.getName());
        } else {
            model.addAttribute("name", "Anonymous");
        }
        return "greeting";
    }

    @GetMapping("/all_orders")
    public String allOrders(Model model){
        List<OrdersEntity> ordersEntityList = orderService.getAllOrders();
        model.addAttribute("orders", ordersEntityList);
        return "all_orders";
    }
}