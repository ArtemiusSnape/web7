package model.DAO;

import model.entities.User;
import model.entities.User_;
import model.exceptions.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DAOUser class.
 * @autor Alexander Rai
 * @version 1.0
 */
public class DAOUser extends DAO{

    /**
     * Creates DAO class
     */
    public DAOUser() throws DAOException {
        super();
    }

    /**
     * Returns all users from database
     * */
    public List<User> getAllUsers() throws DAOException {
        EntityManager entityManager = null;
        List<User> users = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> user = cq.from(User.class);
            cq.select(user);
            TypedQuery<User> q = entityManager.createQuery(cq);
            users = q.getResultList();
        } catch (Exception e) {
            throw new DAOException("Failed to get all users", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return users;
    }

    /**
     * Checks if user's login valid
     * */
    public boolean isLoginValid(String login) throws DAOException {
        EntityManager entityManager = null;
        boolean result = false;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<User> user = cq.from(User.class);

            cq.select(cb.count(user));
            cq.where(cb.equal(user.get(User_.login), login));

            TypedQuery<Long> tq = entityManager.createQuery(cq);
            result = tq.getSingleResult() > 0;

        } catch (Exception e) {
            throw new DAOException("Failed to check user's login", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }

        return result;
    }

    /**
     * Returns user by login and password or null if cridentials are not valid
     * */
    public User getUserByLoginPass(String login, String password) throws DAOException {
        EntityManager entityManager = null;
        User result = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> user = cq.from(User.class);

            cq.select(user);
            cq.where(cb.equal(user.get(User_.login), login), cb.equal(user.get(User_.password), password));


            TypedQuery<User> tq = entityManager.createQuery(cq);
            result = tq.getSingleResult();

        }catch (NoResultException ex){
            return null;
        }catch (Exception e) {
            throw new DAOException("Failed to get user", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }

        return result;
    }

    /**
     * Inserts user to database
     * */
    public void insertUser(User user) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("Failed while inserting", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
}
