package oltiv.Dao.Impl;

import oltiv.Dao.Interface.HostelDao;
import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import oltiv.business.Prapti;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by pankaj on 5/12/16.
 */
public class HostelDaoImpl implements HostelDao {

    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {return sessionFactory;}
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    public List<Hostel> getAllHostels() {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM Hostel";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Hostel.class);
        List<Hostel> results = query.list();
        return results;
    }

    @Override
    public void createHostel(Hostel hostel) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(hostel);
    }

    @Override
    public void addFlankToHostel(HostelFlank flank) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(flank);
    }

    @Override
    public List<HostelFlank> getHostelFlank(int id) {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM Hostel_flank where hostelId="+id;
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(HostelFlank.class);
        List<HostelFlank> results = query.list();
        return results;
    }

}
