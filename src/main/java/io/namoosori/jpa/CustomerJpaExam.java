package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //실제넣을객체를 persist로 전달
        em.persist(Customer.sample());
        tx.commit(); // 문제가 있었을때는 tx.rollback()
        System.out.println("커밋완료 추정");
        em.close();
        emf.close();

    }
}
