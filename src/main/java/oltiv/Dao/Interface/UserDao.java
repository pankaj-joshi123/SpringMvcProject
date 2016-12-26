package oltiv.Dao.Interface;

import oltiv.business.User;

/**
 * Created by pankaj on 5/12/16.
 */
public interface UserDao {
    public void saveUser(User abc);

    public void createUser(User user);

    public User getUserByLoginName(String name);
}
