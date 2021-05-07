package ru.fintech.qa.homework.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.fintech.qa.homework.utils.models.Animal;
import ru.fintech.qa.homework.utils.models.Places;
import ru.fintech.qa.homework.utils.models.Workman;


public class DBHibernateService {
    public final int number(final String title) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createNativeQuery("select * from " + title).getResultList().size();
    }

    public final void addAnimal(final int id, final String name, final int age, final int type, final int sex,
                                final int place) {
        Animal animal = new Animal();
        animal.setId(id);
        animal.setName(name);
        animal.setAge(age);
        animal.setType(type);
        animal.setSex(sex);
        animal.setPlace(place);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        session.close();
    }

    public final void addWorkman(final int id, final String name, final int age, final int position) {
        Workman workman = new Workman();
        workman.setId(id);
        workman.setName(name);
        workman.setAge(age);
        workman.setPosition(position);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(workman);
        session.getTransaction().commit();
        session.close();
    }

    public final void addPlace(final int id, final int row, final int placeNum, final String name) {
        Places place = new Places();
        place.setId(id);
        place.setRow(row);
        place.setPlaceNum(placeNum);
        place.setName(name);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(place);
        session.getTransaction().commit();
        session.close();
    }

    public final int checkMatchesZoo(final String title, final String nameList) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createNativeQuery("select * from " + title + " where \"name\" in (" + nameList + ")")
                .getResultList().size();
    }
}
