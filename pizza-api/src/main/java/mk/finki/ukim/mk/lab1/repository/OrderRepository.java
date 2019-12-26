package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
