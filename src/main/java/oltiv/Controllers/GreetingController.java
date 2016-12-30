package oltiv.Controllers;

import oltiv.business.User;
import oltiv.service.Impl.EmailServiceImpl;
import oltiv.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public User getUserByLoginName(@PathVariable String  name) {  //return type is complete user object for further uses
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
}

