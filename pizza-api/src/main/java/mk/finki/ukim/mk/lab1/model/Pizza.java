package mk.finki.ukim.mk.lab1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<Ingredient> ingredients;

    @Column(name = "veggie")
    private boolean veggie;

    public Pizza() {
    }

    public Pizza(String name, String description, List<Ingredient> ingredientList, boolean veggie) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredientList;
        this.veggie = veggie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }
}
