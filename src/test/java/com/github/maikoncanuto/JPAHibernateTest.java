package com.github.maikoncanuto;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHibernateTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    @BeforeClass
    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default-test");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown(){
        entityManager.clear();
        entityManager.close();
        entityManagerFactory.close();
    }
}
