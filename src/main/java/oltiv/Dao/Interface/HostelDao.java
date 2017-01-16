package oltiv.Dao.Interface;

import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import oltiv.business.Prapti;

import java.util.List;

/**
 * Created by pankaj on 5/12/16.
 */
public interface HostelDao {
    public List<Hostel> getAllHostels();

    public void createHostel(Hostel hostel);

    public void addFlankToHostel(HostelFlank flank);

    public List<HostelFlank> getHostelFlank(int id);
}
