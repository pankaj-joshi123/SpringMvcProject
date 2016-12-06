package oltiv.service.Impl;

import oltiv.Dao.Interface.MasterDao;
import oltiv.business.Prapti;
import oltiv.service.Interface.PraptiService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

public class PraptiServiceImpl implements PraptiService {

    private Prapti prapti;
    private MasterDao masterDao;

    public Prapti getPrapti() {
        return prapti;
    }
    public void setPrapti(Prapti prapti) {
        this.prapti = prapti;
    }
    public MasterDao getMasterDao() {return masterDao;}
    public void setMasterDao(MasterDao masterDao) {this.masterDao = masterDao;}

    private static SessionFactory factory;


    @Override
    @Transactional
    public void addBoyFrndName() {
        masterDao.getPraptiDao().savePraptiBoyFriend(prapti);
    }
}
