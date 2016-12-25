package oltiv.service.Impl;

import oltiv.Dao.Interface.MasterDao;
import oltiv.business.User;
import oltiv.service.Interface.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pankaj on 26/11/16.
 */
public class UserServiceImpl implements UserService {

    private User abc;
    private MasterDao masterDao;

    public User getAbc() {
        return abc;
    }
    public void setAbc(User abc) {
        this.abc = abc;
    }
    public MasterDao getMasterDao() {return masterDao;}
    public void setMasterDao(MasterDao masterDao) {this.masterDao = masterDao;}

    @Override
    @Transactional
    public void saveUser() {
        masterDao.getUserDao().saveUser(abc);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        masterDao.getUserDao().createUser(user);
    }
}
