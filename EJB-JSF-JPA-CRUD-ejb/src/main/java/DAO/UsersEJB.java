package DAO;

import Entity.DeletedUsers;
import Entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class UsersEJB {

    @PersistenceContext(unitName = "persistence")
    private EntityManager em;

    public List<Users> allUsers() {
        TypedQuery<Users> sorgu = em.createNamedQuery("allUsers", Users.class);
        return sorgu.getResultList();
    }
    
    public List<DeletedUsers> allDeleteUsers() {
        TypedQuery<DeletedUsers> sorgu = em.createNamedQuery("allDeleteUsers", DeletedUsers.class);
        return sorgu.getResultList();
    }

    public Users getXUser(String username) {
        return em.find(Users.class, username);
    }

    public Users getXEmail(Long id) {
        return em.find(Users.class, id);
    }

    public List mail(String email) {
        Query q = em.createQuery("SELECT u FROM USERS1 u WHERE u.email = :email");
        q.setParameter("email", email);
        List result = (ArrayList) q.getResultList();

        return result;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Users saveUser(Users user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public DeletedUsers saveUserWithDeleteReason(DeletedUsers delUser) {
        em.persist(delUser);
        em.flush();
        return delUser;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Users mergeUser(Users user) {

        System.out.println("--------------------5--------------------------------");
        System.out.println(user.getId());
        System.out.println("----------------------6------------------------------");
        em.merge(em.find(Users.class, user.getId()));

        System.out.println("------------------------7----------------------------");
        return user;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteUsers(Users user) throws Exception {
        try {
            em.remove(em.merge(user));
            em.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Users editUsers(Users user) throws Exception {
        try {
            System.out.println("User hereko " + user);
            em.merge(user);
            em.flush();
            return user;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

}