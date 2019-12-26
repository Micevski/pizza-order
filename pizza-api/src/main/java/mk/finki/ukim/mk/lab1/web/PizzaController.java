package mk.finki.ukim.mk.lab1.web;

import javassist.NotFoundException;
import mk.finki.ukim.mk.lab1.model.Pizza;
import mk.finki.ukim.mk.lab1.model.PizzaRequest;
import mk.finki.ukim.mk.lab1.service.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> findAll(){
        return pizzaService.listPizzas();
    }

    @GetMapping("/{id}")
    public Pizza findById(@PathVariable Long id) throws NotFoundException {
        return pizzaService.findById(id);
    }

    @PostMapping
    public Pizza createPizza(@RequestBody PizzaRequest request) {
        return pizzaService.savePizza(request);
    }

    @PutMapping("/{id}")
    public Pizza updatePizza(@PathVariable Long id,
                             @RequestBody PizzaRequest request) throws NotFoundException {
        return pizzaService.updatePizza(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaService.deletePizza(id);
    }
}
