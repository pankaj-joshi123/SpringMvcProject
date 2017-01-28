package oltiv.service.Interface;

import oltiv.business.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pankaj on 26/11/16.
 */
public interface UserService {
    public void saveUser();

    public void createUser(User user);

    public User getUserByLoginName(String name);

    public List<User> getAllUsers();

    public void addMultipleUsers(String[] details);

    public List<User> getAllUsersOfRoom(int roomId);
}
