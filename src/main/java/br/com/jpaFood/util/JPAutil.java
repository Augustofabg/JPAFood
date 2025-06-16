package br.com.jpaFood.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutil {
    private static final EntityManagerFactory JPAFOOD = Persistence.createEntityManagerFactory("jpaFood");

    public static EntityManager getEntityManagerJPAFOOD(){
        return JPAFOOD.createEntityManager();
    }

}
