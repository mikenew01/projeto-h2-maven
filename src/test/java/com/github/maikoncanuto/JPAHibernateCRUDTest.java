package com.github.maikoncanuto;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.stream.Stream.iterate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JPAHibernateCRUDTest extends JPAHibernateTest {

    @Before
    public void setUp() {
        iterate(0, n -> n + 1)
                .limit(10)
                .forEach(i -> {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome("NOME-" + i);
                    entityManager.persist(pessoa);

                    Cachorro cachorro = new Cachorro();
                    cachorro.setNome("CACHORRO" + i);
                    entityManager.persist(cachorro);
                });
    }

    @Test
    public void testFindPessoa() {
        Pessoa pessoa = entityManager.find(Pessoa.class, 1);
        assertNotNull(pessoa);
        assertEquals(pessoa.getId(), Integer.valueOf(1));
    }

    @Test
    public void testFindCachorro() {
        Cachorro cachorro = entityManager.find(Cachorro.class, 10);
        assertNotNull(cachorro);
        assertEquals(cachorro.getId(), Integer.valueOf(10));
    }

    @After
    public void tearDownMethod() {
    }

}
