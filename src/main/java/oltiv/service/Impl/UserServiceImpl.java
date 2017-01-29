package oltiv.service.Impl;

import au.com.bytecode.opencsv.CSVWriter;
import oltiv.Dao.Interface.MasterDao;
import oltiv.business.User;
import oltiv.service.Interface.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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

    @Override
    @Transactional
    public User getUserByLoginName(String name) {
        User user=masterDao.getUserDao().getUserByLoginName(name);
        return user;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users=masterDao.getUserDao().getAllUsers();
        return users;
    }

    @Override
    @Transactional
    public void addMultipleUsers(String[] details) {
        User newUser= new User();
        newUser.makeUser(details);
        createUser(newUser);
    }

    @Override
    @Transactional
    public List<User> getAllUsersOfRoom(int roomId) {
        List<User> users=masterDao.getUserDao().getAllUsersOfRoom(roomId);
        return users;
    }

    @Override
    @Transactional
    public void sendToPrint() {

        String outputFile = "/home/pankaj/IdeaProjects/openspec/src/main/resources/usersList.csv";

        try {
            CSVWriter csvOutput = new CSVWriter(new FileWriter(outputFile, false), ',');
            List<User> users=getAllUsers();
            String [] headers = "ID#Name#Last Name#Login Name#Email".split("#");
            csvOutput.writeNext(headers);

            for (int i=0;i<users.size();i++) {
                String [] user=new String[6];

                user[0]= String.valueOf(users.get(i).getId());
                user[1]= users.get(i).getName();
                user[2]= users.get(i).getLastname();
                user[3]= users.get(i).getLoginName();
                user[4]= users.get(i).getEmail();

                csvOutput.writeNext(user);
            }

            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
