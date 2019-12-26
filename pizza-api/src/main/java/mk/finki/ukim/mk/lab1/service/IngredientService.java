package mk.finki.ukim.mk.lab1.service;

import javassist.NotFoundException;
import mk.finki.ukim.mk.lab1.model.Ingredient;
import mk.finki.ukim.mk.lab1.repository.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }


    public Ingredient saveIngredient(String name, boolean spicy, float amount, boolean veggie) {
        Ingredient ingredient = new Ingredient(name, spicy, amount, veggie);
        return repository.save(ingredient);
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Ingredient updateIngredient(Long id, String name, boolean spicy, float amount, boolean veggie) throws NotFoundException {
        Ingredient ingredient = findById(id);
        ingredient.setName(name);
        ingredient.setSpicy(spicy);
        ingredient.setAmount(amount);
        ingredient.setVeggie(veggie);
        return ingredient;
    }

    public void deleteIngredient(Long id) {
        repository.deleteById(id);
    }

    public Page<Ingredient> allIngredients(Integer pageSize, Integer page) {
        Pageable p = PageRequest.of(pageSize, page, Sort.by("name"));
        return repository.findAll(p);

    }

    public Ingredient findById(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Ingredient with id: %d not found", id)));
    }

    public List<Ingredient> findAllById(List<Long> ingredientsIds) {
        return repository.findAllById(ingredientsIds);
    }
}
