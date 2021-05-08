package ru.fintech.qa.homework.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fintech.qa.homework.utils.models.Animal;
import ru.fintech.qa.homework.utils.models.Places;
import ru.fintech.qa.homework.utils.models.Workman;
import ru.fintech.qa.homework.utils.models.Zoo;

public class HibernateSessionCreator {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Places.class)
                .addAnnotatedClass(Workman.class)
                .addAnnotatedClass(Zoo.class)
                .buildSessionFactory();
    }
}
