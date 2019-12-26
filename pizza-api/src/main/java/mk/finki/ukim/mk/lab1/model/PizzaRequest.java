package mk.finki.ukim.mk.lab1.model;

import java.util.List;

public class PizzaRequest {
    public String name;
    public String description;
    public List<Long> ingredientsIds;

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

    public List<Long> getIngredientsIds() {
        return ingredientsIds;
    }

    public void setIngredientsIds(List<Long> ingredientsIds) {
        this.ingredientsIds = ingredientsIds;
    }
}


