package oltiv.Dao.Interface;

import oltiv.business.Hostel;
import oltiv.business.Prapti;

import java.util.List;

/**
 * Created by pankaj on 5/12/16.
 */
public interface HostelDao {
    public List<Hostel> getAllHostels();

    public void createHostel(Hostel hostel);
}
