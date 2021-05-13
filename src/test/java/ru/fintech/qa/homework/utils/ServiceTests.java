package ru.fintech.qa.homework.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.persistence.PersistenceException;

public class ServiceTests {

    @BeforeAll
    public static void createData() {
        BeforeUtils.createData();
    }

    @Test
    public void insertTest1() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        int actual = new DBHibernateService().number("animal");
        int expected = 10;
        Assertions.assertEquals(expected, actual);
        session.close();
    }

    @Test
    public void insertTest2() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        new DBHibernateService().addAnimalId(11);
        session.close();
    }

    //При добавлении строки с именем "null" тест должен упасть
    @Test
    public void insertTest3() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
         try {
            new DBHibernateService().addWorkman(7, "", 15, 3);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void insertTest4() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        int expected = 6;
        int actualId = new DBHibernateService().number("places") + 1;
        new DBHibernateService().addPlace(actualId, 4, 1635, "New");
        int actual = new DBHibernateService().number("places");
        Assertions.assertEquals(expected, actual);
        session.close();
    }

    @Test
    public void insertTest5() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        int expexted = 3;
        int actual = new DBHibernateService().checkMatchesZoo("zoo", "'Центральный', 'Северный', 'Западный'");
        System.out.println(actual);
        Assertions.assertEquals(expexted, actual);
        session.close();
    }
}
