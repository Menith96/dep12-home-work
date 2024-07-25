package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;
import lk.ijse.dep12.jpa.relatioship.entity.CustomerContact;

import java.util.List;

public class ExerciseDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();

//                Customer menith = new Customer("C001", "Menith", "Rathnapura");
                Customer dasun = new Customer("C002", "Dasun", "Matara");
//                CustomerContact customerContact1 = new CustomerContact(menith, "071-4364363");
//                CustomerContact customerContact2= new CustomerContact(menith, "076-9144363");
                CustomerContact customerContact3= new CustomerContact(dasun, "076-4564564");


                List.of(dasun,customerContact3).forEach(em::persist);
                transaction.commit();
            }catch (Throwable t){
                transaction.rollback();
                t.printStackTrace();
            }
        }
    }
}