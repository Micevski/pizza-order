package mk.finki.ukim.mk.lab1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "spicy")
    private boolean spicy;

    @Column(name = "amount")
    private float amount;

    @Column(name = "veggie")
    private boolean veggie;

    public Ingredient(){};
    public Ingredient(String name, boolean spicy, float amount, boolean veggie) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }
}
