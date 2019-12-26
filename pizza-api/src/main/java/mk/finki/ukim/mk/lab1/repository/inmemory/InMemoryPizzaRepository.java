package mk.finki.ukim.mk.lab1.repository.inmemory;

import mk.finki.ukim.mk.lab1.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPizzaRepository {
    List<Pizza> pizzas;

    public InMemoryPizzaRepository() {
        pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Calabrese Pizza", "Пелат, кашкавал, лук, магдонос и маслиново масло", null, false));
        pizzas.add(new Pizza("Pizza Oliv", "Пелат, кашкавал, маслинки", null, false));
        pizzas.add(new Pizza("Lantern Pizza", "пелат, растителен кашкавал, домат, пиперка, маслинки, тиквица, свежи шампињони, рукола", null, false));
        pizzas.add(new Pizza("Pizza Toto", "пелат, кашкавал, кулен, свежи шампињони, фета сирење", null, false));
        pizzas.add(new Pizza("Pizza Carbonara", "пелат, кашкавал, сланина, маслинки, јајца, рукола", null, false));
        pizzas.add(new Pizza("Pizza Margherita", "пелат, кашкавал, маслиново масло", null, false));
        pizzas.add(new Pizza("Macedonian Pizza", "пелат, кашкавал, домат, пиперка, бело сирење", null, false));
        pizzas.add(new Pizza("Funghi Pizza", "пелат, кашкавал, свежи шампињони", null, false));
        pizzas.add(new Pizza("Pizza Vesuvio", "пелат, кашкавал, шунка", null, false));
        pizzas.add(new Pizza("Capricciosa", "пелат, кашкавал, шунка, свежи шампињони", null, false));
    }

    //    @Override
    public List<Pizza> findAll() {
        return pizzas;
    }
}
