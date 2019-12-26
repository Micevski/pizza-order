package mk.finki.ukim.mk.lab1.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "pizza_type")
    private String pizzaType;

    @Column(name = "pizza_size")
    private String pizzaSize;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_address")
    private String clientAddress;

    public Order() {
    }

    public Order(String pizzaType, String pizzaSize, String clientName, String clientAddress){
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
}
