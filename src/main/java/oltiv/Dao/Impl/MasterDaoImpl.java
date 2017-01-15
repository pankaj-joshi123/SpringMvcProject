package oltiv.Dao.Impl;

import oltiv.Dao.Interface.HostelDao;
import oltiv.Dao.Interface.MasterDao;
import oltiv.Dao.Interface.PraptiDao;
import oltiv.Dao.Interface.UserDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by pankaj on 5/12/16.
 */
public class MasterDaoImpl implements MasterDao {

    private  SessionFactory sessionFactory;
    public  void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    public UserDao getUserDao() {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.setSessionFactory(sessionFactory);    ///it is called as passing session factory to all
        return userDao;
    }

    @Override
    public PraptiDao getPraptiDao() {
        PraptiDaoImpl praptiDao=new PraptiDaoImpl();
        praptiDao.setSessionFactory(sessionFactory);    ///master will pass session factory to whose dao is called
        return praptiDao;
    }

    @Override
    public HostelDao getHostelDao() {
        HostelDaoImpl hostelDao=new HostelDaoImpl();
        hostelDao.setSessionFactory(sessionFactory);    ///master will pass session factory to whose dao is called
        return hostelDao;
    }

}
