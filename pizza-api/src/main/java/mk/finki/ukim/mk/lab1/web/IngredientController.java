package mk.finki.ukim.mk.lab1.web;

import javassist.NotFoundException;
import mk.finki.ukim.mk.lab1.model.Ingredient;
import mk.finki.ukim.mk.lab1.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @PostMapping
    public Ingredient createIngredient(@RequestParam String name,
                                       @RequestParam boolean spicy,
                                       @RequestParam float amount,
                                       @RequestParam boolean veggie) {
        return service.saveIngredient(name, spicy, amount, veggie);
    }

    @GetMapping
    public List<Ingredient> findAll(){
        return service.findAll();
    }

    @GetMapping("/pageable")
    public Page<Ingredient> findAllPageable(@RequestParam Integer pageSize,
                                            @RequestParam Integer page) {
        return service.allIngredients(pageSize, page);
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable Long id) throws NotFoundException {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Long id,
                                       @RequestBody String name,
                                       @RequestBody boolean spicy,
                                       @RequestBody float amount,
                                       @RequestBody boolean veggie) throws NotFoundException {
        return service.updateIngredient(id, name, spicy, amount, veggie);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        service.deleteIngredient(id);
    }

}
