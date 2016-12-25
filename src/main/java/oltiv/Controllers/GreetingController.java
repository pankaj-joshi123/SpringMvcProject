package oltiv.Controllers;

import oltiv.business.User;
import oltiv.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    UserService userSvc;

    @RequestMapping(value="/all", method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void greeting1() {
        userSvc.saveUser();
    }

    @RequestMapping(value="/create", method =RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createUser(@RequestBody User userDetails) {   ///Recieving details from front end
        userSvc.createUser(userDetails);
    }
}

