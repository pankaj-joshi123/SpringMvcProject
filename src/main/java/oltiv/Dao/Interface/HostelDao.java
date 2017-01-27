package oltiv.Dao.Interface;

import oltiv.business.FlankRooms;
import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import oltiv.business.Prapti;

import java.util.List;

/**
 * Created by pankaj on 5/12/16.
 */
public interface HostelDao {
    public List<Hostel> getAllHostels();

    public Hostel createHostel(Hostel hostel);

    public Hostel getHostelOverview(int hostelId);

    public HostelFlank addFlankToHostel(HostelFlank flank);

    public HostelFlank getFlankOverview(int flankId);

    public List<HostelFlank> getHostelFlank(int id);

    public List<FlankRooms> getFlankRooms(int flankId);
}
