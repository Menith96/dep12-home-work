package lk.ijse.dep12.jpa.relationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailsPK implements Serializable {
    private Item item;
    private Order order;
}
