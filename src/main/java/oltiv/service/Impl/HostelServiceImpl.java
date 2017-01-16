package oltiv.service.Impl;

import oltiv.Dao.Interface.MasterDao;
import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import oltiv.service.Interface.HostelService;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HostelServiceImpl implements HostelService {

    private MasterDao masterDao;
    public MasterDao getMasterDao() {return masterDao;}
    public void setMasterDao(MasterDao masterDao) {this.masterDao = masterDao;}

    private static SessionFactory factory;

    @Override
    @Transactional
    public List<Hostel> getAllHostels() {
        List<Hostel> hostels=masterDao.getHostelDao().getAllHostels();
        return hostels;
    }

    @Override
    @Transactional
    public void createHostel(Hostel hostel) {
        masterDao.getHostelDao().createHostel(hostel);
    }

    @Override
    @Transactional
    public void createFlank(HostelFlank flank) {
        masterDao.getHostelDao().addFlankToHostel(flank);
    }

    @Override
    @Transactional
    public List<HostelFlank> getHostelsFlank(int id) {
        List<HostelFlank> flanks=masterDao.getHostelDao().getHostelFlank(id);
        return flanks;
    }
}
