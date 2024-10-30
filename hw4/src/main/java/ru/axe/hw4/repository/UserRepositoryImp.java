package ru.axe.hw4.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.axe.hw4.entity.User;

import java.util.List;


@Repository
public class UserRepositoryImp implements UserRepository {


    @Override
    public User add(User user) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<User> usersList = session.createQuery("FROM User")
                    .list();
            session.getTransaction().commit();
            return usersList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getById(Integer id) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<User> usersList = session.createQuery("FROM User WHERE id = " + id.toString())
                    .list();
            session.getTransaction().commit();
            return usersList.getFirst();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE User WHERE id = " + id.toString()).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Удален пользователь с ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
