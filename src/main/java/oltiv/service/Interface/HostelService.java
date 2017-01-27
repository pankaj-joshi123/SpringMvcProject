package oltiv.service.Interface;

import oltiv.business.FlankRooms;
import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pankaj on 26/11/16.
 */
public interface HostelService {

    public List<Hostel> getAllHostels();

    public Hostel createHostel(Hostel hostel);

    public Hostel getHostelOverview(int hostelId);

    public HostelFlank createFlank(HostelFlank flank);

    public HostelFlank getFlankOverview(int flankId);

    public List<HostelFlank> getHostelsFlank(int id);

    public List<FlankRooms> getFlankRooms(int flankId);
}
