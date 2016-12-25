package oltiv.Dao.Impl;

import oltiv.Dao.Interface.UserDao;
import oltiv.business.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by pankaj on 5/12/16.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {return sessionFactory;}
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    public void saveUser(User abc) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(abc);
    }

    @Override
    public void createUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
