package com.repo;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepImplement implements UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepImplement(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User order by id asc").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void update(User user, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user1 = session.get(User.class, id);
        user1.setName(user.getName());
        user1.setCar(user.getCar());
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class, id));
    }

}
