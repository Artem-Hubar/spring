package com.example_spring.spring.servingwebcontent;

import com.example_spring.spring.db.ConsumerEntity;
import com.example_spring.spring.db.OrdersEntity;
import com.example_spring.spring.db.SellerEntity;
import com.example_spring.spring.forms.OrderDeleteForm;
import com.example_spring.spring.forms.OrdersForm;
import com.example_spring.spring.services.ConsumerService;
import com.example_spring.spring.services.OrderService;
import com.example_spring.spring.services.SellerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Controller
public class GreetingController {

    @Autowired

    private ConsumerService consumerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SellerService sellerService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        ConsumerEntity consumer = null;
//        for (GrantedAuthority authority : userDetails.getAuthorities()) {
//            String role = authority.getAuthority();
//            // Делаем что-то с ролью
//            System.out.println("Роль пользователя: " + role);
//        }
        if (name != null && userDetails != null) {
            try {
                int id = Integer.parseInt(name);
                consumer = consumerService.getConsumerById(id);
            } catch (NumberFormatException e) {
                // Если параметр не является числом, то обрабатываем его как имя пользователя
//                model.addAttribute("name", name);
                model.addAttribute("name", userDetails.getUsername());

                return "greeting";
            }
        }
        if (consumer != null) {
            model.addAttribute("name", consumer.getName());
        } else {
            model.addAttribute("name", "Anonymous");
        }
        if (userDetails != null){
            out.println(userDetails.getUsername());
            model.addAttribute("name", userDetails.getUsername());
        }

        return "greeting";
    }

    @GetMapping("/all_orders")
    public String allOrders(Model model) {
        List<OrdersEntity> ordersEntityList = orderService.getAllOrders();
        model.addAttribute("orders", ordersEntityList);
        return "all_orders";
    }

    @GetMapping("/create_orders")
    public String createOrders(Model model) {
        OrdersForm form = new OrdersForm();
        form.setConsumerEntityList(consumerService.getAllConsumers());
        form.setSellerEntityList(sellerService.getAllSellors());
        model.addAttribute("form", form);
        out.println(1231);
        return "create_orders";
    }


    @PostMapping("/save")
    public String saveBooks(@ModelAttribute OrdersForm form, Model model) {
        SellerEntity selectedSeller = form.getSelectedSeller();
        ConsumerEntity selectedConsumer = form.getSelectedConsumer();

        out.println("test");
        if (selectedSeller != null && selectedConsumer != null) {
            OrdersEntity order = new OrdersEntity();
            order.setTitle(form.getTitle());
            order.setAmount(form.getAmount());
            order.setSellerBySelleridSeller(selectedSeller);
            order.setConsumerByConsumerIdConsumer(selectedConsumer); // Установка соответствующего потребителя
            orderService.save(order);
        }
        return "redirect:/all_orders";
    }

    @GetMapping("/delete_orders")
    public String deleteOrders(Model model) {
        List<OrdersEntity> ordersEntityList = orderService.getAllOrders();

        model.addAttribute("orders", ordersEntityList);
        model.addAttribute("form", new OrderDeleteForm());
        return "delete_orders";
    }

    @PostMapping("/post_delete_order")
    public String postDeleteOrder(@ModelAttribute OrderDeleteForm form) {
        orderService.deleteOrderByEntity(form.getOrdersEntity());
        return "redirect:/all_orders";
    }


//    LOGIN


    @GetMapping("/custom-login")
    public String login() {
        return "custom-login";
    }

    @GetMapping("/custom-logout")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/custom-login?logout";
    }
}