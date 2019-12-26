package mk.finki.ukim.mk.lab1.service;

import javassist.NotFoundException;
import mk.finki.ukim.mk.lab1.event.MethodLoggingEvent;
import mk.finki.ukim.mk.lab1.model.Ingredient;
import mk.finki.ukim.mk.lab1.model.Pizza;
import mk.finki.ukim.mk.lab1.model.PizzaRequest;
import mk.finki.ukim.mk.lab1.repository.PizzaRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final ApplicationEventPublisher publisher;
    private final IngredientService ingredientService;

    public PizzaService(PizzaRepository pizzaRepository, ApplicationEventPublisher publisher, IngredientService ingredientService) {
        this.pizzaRepository = pizzaRepository;
        this.publisher = publisher;
        this.ingredientService = ingredientService;
    }

    public List<Pizza> listPizzas() {
        publisher.publishEvent(new MethodLoggingEvent(this, "PizzaService.listPizzas()"));
        return pizzaRepository.findAll();
    }

    public Pizza savePizza(PizzaRequest request) {
        List<Ingredient> ingredients = ingredientService.findAllById(request.ingredientsIds);
        Pizza pizza = new Pizza(request.name, request.description, ingredients, false);
        return pizzaRepository.save(pizza);
    }

    @Transactional
    public Pizza updatePizza(Long id, PizzaRequest request) throws NotFoundException {
        Pizza pizza = findById(id);
        pizza.setName(request.name);
        pizza.setDescription(request.description);
        pizza.setIngredients(ingredientService.findAllById(request.ingredientsIds));
        return pizza;
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }

    public Pizza findById(Long id) throws NotFoundException {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Pizza with id:[%d] not found", id)));
    }
}
