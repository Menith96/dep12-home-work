package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.*;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ExerciseDemo3 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                    Customer c001 = em.find(Customer.class,"C001");
                    Customer c002 = em.find(Customer.class,"C002");

                    User u001 = em.find(User.class,"U001");
                    User u002 = em.find(User.class,"U002");

                    Item i001 = em.find(Item.class,"I001");
                    Item i002 = em.find(Item.class,"I002");
                    Item i003 = em.find(Item.class,"I003");


                OrderDetails orderDetails1 = new OrderDetails(null, i001, 10, i001.getPrice());
                OrderDetails orderDetails2 = new OrderDetails(null, i002, 10, i002.getPrice());

                List<OrderDetails> orderDetails = List.of(orderDetails1, orderDetails2);
                Order o001 = new Order("O001", c001, Date.valueOf(LocalDate.now()), u001, orderDetails);

                em.persist(o001);


                transaction.commit();
            }catch (Throwable t){
                transaction.rollback();
                t.printStackTrace();
            }
        }
    }
}