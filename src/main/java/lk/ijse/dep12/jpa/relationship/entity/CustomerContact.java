package lk.ijse.dep12.jpa.relatioship.entity;

import jakarta.persistence.*;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_contact")
public class CustomerContact {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Id
    private String contact;
}