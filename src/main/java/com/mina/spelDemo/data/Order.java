package com.mina.spelDemo.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("order")
@Setter
@Getter
public class Order {
    @Value("#{100.55 + 200.00 + 800.0}")
    private double amount;
    @Value("#{order.amount >= 1000 ? order.amount * 0.05 : 0.0}")
    private double discount;
    @Value("#{user.country == 'US' and user.timeZone == 'America/New_York' ? 3 : 14}")
    private int dayToDeliver;
    @Value("#{user.country}")
    private String origin;

    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.amount)}")
    private String formattedAmount;

    @Value("#{user.name} your order total is #{order.formattedAmount} and the payable amount with 5 % discount is #{order.discount}")
    private String orderSummary;
}
