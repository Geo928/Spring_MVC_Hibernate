package spring.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        em = entityManager;
    }

    @Transactional
    @Override
    public List<User> getAllUsers()  {
        String hql = "SELECT a FROM User a";
        return em.createQuery(hql, User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        em.remove(getUserById(id));
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        em.merge(user);
    }
}
