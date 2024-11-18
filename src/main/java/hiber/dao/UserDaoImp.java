package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   
   private final SessionFactory sessionFactory;
   
   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }
   
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   
   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      String hql = "SELECT u FROM User u JOIN FETCH u.car c WHERE c.model = :model AND c.series = :series";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }
   
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("SELECT u FROM User u JOIN FETCH u.car c");
      return query.getResultList();
   }

}
