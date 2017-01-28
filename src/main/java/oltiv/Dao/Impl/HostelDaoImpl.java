package oltiv.Dao.Impl;

import oltiv.Dao.Interface.HostelDao;
import oltiv.business.FlankRooms;
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
    public Hostel createHostel(Hostel hostel) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(hostel);
        return hostel;                                                ///once it is saved then id will be attatched to this database object
    }

    @Override
    public Hostel getHostelOverview(int id) {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM Hostel where id="+id;
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Hostel.class);
        Hostel results = (Hostel) query.list().get(0);
        return results;
    }

    @Override
    public HostelFlank addFlankToHostel(HostelFlank flank) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(flank);                                 ///as the flank is created we will create the rooms fot this flank also

        int totalrooms=flank.getNoOfRooms()*flank.getColumns();
        int startingRoomNo=flank.getStaringRoomNo();

        for(int i=0;i<totalrooms;i++)
        {
            FlankRooms room= new FlankRooms();
            room.setRoomLabel("Room:"+String.valueOf(startingRoomNo));
            room.setCapacityOfRoom(flank.getStudenPerRoom());
            room.setFlankId(flank.getId());                                        ////saving rooms and increasing the room numbers   giving the id of flank to which each room belongs
            startingRoomNo++;
            System.out.print("\n\n\n\n\n\n\n\n"+room.getRoomLabel()+"\n\n\nsaving room\n\n\n\n\n");
            session.saveOrUpdate(room);
        }

        return flank;                                             ///now id will be attatched to the flank object for the overview purpose
    }

    @Override
    public HostelFlank getFlankOverview(int id) {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM Hostel_flank where id="+id;
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(HostelFlank.class);
        HostelFlank results = (HostelFlank) query.list().get(0);
        return results;
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

    @Override
    public List<FlankRooms> getFlankRooms(int flankId) {
        Session session=sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM Room where flankId="+flankId;
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(FlankRooms.class);                             //// the query add entity is very important else it will search if any columns is left of this class and give error
        List<FlankRooms> results = query.list();
        return results;
    }

}
