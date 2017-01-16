package oltiv.service.Interface;

import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pankaj on 26/11/16.
 */
public interface HostelService {

    public List<Hostel> getAllHostels();

    public void createHostel(Hostel hostel);

    public void createFlank(HostelFlank flank);

    public List<HostelFlank> getHostelsFlank(int id);
}
