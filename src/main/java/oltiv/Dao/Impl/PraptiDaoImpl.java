package oltiv.Dao.Impl;

import oltiv.Dao.Interface.PraptiDao;
import oltiv.business.Prapti;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by pankaj on 5/12/16.
 */
public class PraptiDaoImpl implements PraptiDao {


    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {return sessionFactory;}
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    public void savePraptiBoyFriend(Prapti prapti) {

        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(prapti);
        System.out.print("sesssion"+"\n\n\n\n\n\n"+session+"\n\n\n\n\n\n");

        //sessionFactory.getCurrentSession().saveOrUpdate(prapti);
        /*Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(prapti);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }*/
    }

}
