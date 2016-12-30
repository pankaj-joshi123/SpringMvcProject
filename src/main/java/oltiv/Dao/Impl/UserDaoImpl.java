package oltiv.Dao.Impl;

import oltiv.Dao.Interface.UserDao;
import oltiv.business.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

    @Override
    public User getUserByLoginName(String name) {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM User where loginName= :name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(User.class);
        query.setParameter("name", name);
        List<User> results = query.list();
        return results.get(0);
    }

    @Override
    public List<User> getAllUsers() {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM User";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(User.class);
        List<User> results = query.list();
        return results;
    }
}
