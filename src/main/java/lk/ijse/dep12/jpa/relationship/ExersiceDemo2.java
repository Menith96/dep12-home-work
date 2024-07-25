package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Item;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

public class ExersiceDemo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();

                Item item1 = new Item("I001", "Kottu",new BigDecimal("750.00"));
                Item item2 = new Item("I002", "Rice",new BigDecimal("750.00"));
                Item item3 = new Item("I003", "Pasta",new BigDecimal("650.00"));

                List.of(item2,item1,item3).forEach(em::persist);
                transaction.commit();
            }catch (Throwable t){
                transaction.rollback();
                t.printStackTrace();
            }
        }
    }
}