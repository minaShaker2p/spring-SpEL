package com.mina.spelDemo.controller;

import com.mina.spelDemo.data.Order;
import com.mina.spelDemo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    Order order;


    @Autowired
    User user;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomer() {
        return user.getName();
    }

    @RequestMapping(value = "/amount", method = RequestMethod.GET)
    public double getAmount() {
        return order.getAmount();
    }

    @RequestMapping(value = "/discount", method = RequestMethod.GET)
    public double getDiscount() {
        return order.getDiscount();
    }


    @RequestMapping(value = "/origin", method = RequestMethod.GET)
    public String getOrigin() {
        return order.getOrigin();
    }

    @RequestMapping(value = "/deliver", method = RequestMethod.GET)
    public int getDaysToDeliver() {
        return order.getDayToDeliver();
    }

    @RequestMapping(value = "/formatted", method = RequestMethod.GET)
    public String getFormattedAmount() {
        return order.getFormattedAmount();
    }


    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String getOrderSummary() {
        return order.getOrderSummary();
    }
}
