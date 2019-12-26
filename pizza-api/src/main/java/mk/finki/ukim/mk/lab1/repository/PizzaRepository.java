package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findAll();
}
