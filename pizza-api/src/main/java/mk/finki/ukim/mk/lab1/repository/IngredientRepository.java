package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>, PagingAndSortingRepository<Ingredient, Long> {
}
