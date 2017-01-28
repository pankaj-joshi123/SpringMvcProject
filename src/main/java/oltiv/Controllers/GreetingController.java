package oltiv.Controllers;

import liquibase.util.csv.opencsv.CSVReader;
import oltiv.business.User;
import oltiv.service.Impl.EmailServiceImpl;
import oltiv.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    UserService userSvc;

    @RequestMapping(value="/all", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void greeting1() {
        userSvc.saveUser();
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createUser(@RequestBody User userDetails) {   ///Recieving details from front end
        userSvc.createUser(userDetails);
    }

    @RequestMapping(value="/getUserByLoginName/{name}",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUserByLoginName(@PathVariable String  name) {  //for login//return type is complete user object for further uses//
        User user= userSvc.getUserByLoginName(name);
        return user;
    }

    @RequestMapping(value="/forgotPassword/{gmailId:.+}",method=RequestMethod.GET)  //spring truncates the last dot because it consider it as a file .xml .json
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void sendingMailToGmailId(@PathVariable String gmailId) {

        EmailServiceImpl.main(gmailId);
    }

    @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> viewAllUsers() {  ///Returns complete list of all the Users in the Police Department
        List<User> users= userSvc.getAllUsers();
        return users;
    }

    @RequestMapping(value="/getAllUsersOfRoom/{roomId}",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> viewAllUsersOfRoom(@PathVariable int roomId) {  ///Returns complete list of all the Users in the Police Department
        List<User> users= userSvc.getAllUsersOfRoom(roomId);
        return users;
    }

    @RequestMapping(value="/bulkImport",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void bulkImport() throws FileNotFoundException {
        BufferedReader br = null;
        String csvFile = "/home/pankaj/IdeaProjects/openspec/src/main/resources/numbers.csv";
        br = new BufferedReader(new FileReader(csvFile));

        CSVReader reader = new CSVReader(br);
        int i=0;
        String [] nextLine;
        try {
            while ((nextLine = reader.readNext()) != null) {

                i++;if(i==1) continue;
                userSvc.addMultipleUsers(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
