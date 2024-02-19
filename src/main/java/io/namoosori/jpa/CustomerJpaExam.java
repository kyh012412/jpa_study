package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.internal.build.AllowSysOut;

public class CustomerJpaExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            Customer customer = new Customer("ID0004","Kim");
//            em.persist(customer); // insert X persist가 insert인것은 아님

            Customer cus02 = em.find(Customer.class,"ID0004");
            System.out.println(cus02.toString());

            tx.commit(); // 이때 인설트됨
            System.out.println("커밋완료");
        }catch(Exception e){
            // 문제가 있었을때는 tx.rollback()
            tx.rollback();
            System.out.println("커밋실패 & 롤백 가동");
        }finally {
            em.close();
        }
        emf.close();


    }
}
