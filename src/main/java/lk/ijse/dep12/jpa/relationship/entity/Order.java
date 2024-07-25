package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<lk.ijse.dep12.jpa.relationship.entity.OrderDetails> orderDetails = new ArrayList<>();

    public Order(String id, Customer customer, Date date, User user) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.user = user;
    }
    public Order(String id, Customer customer, Date date, User user, List<lk.ijse.dep12.jpa.relationship.entity.OrderDetails> orderDetails) {
        if (orderDetails != null && !orderDetails.isEmpty()){
            orderDetails.stream().filter(od -> od.getOrder() == null).forEach(od -> od.setOrder(this));
            orderDetails.forEach( od -> {
                if (od.getOrder() != this) throw new IllegalStateException("The order %s is already associate with another order".formatted(od.getOrder().getId()));
            });
        }
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    @PrePersist
    public void beforePersist(){
        if(getOrderDetails().isEmpty())
            throw new IllegalStateException("The order does not have any order details");
    }
}