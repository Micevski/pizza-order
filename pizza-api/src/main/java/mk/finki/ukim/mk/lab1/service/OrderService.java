package mk.finki.ukim.mk.lab1.service;

import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }
}
