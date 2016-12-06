package oltiv.Controllers;

import oltiv.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    UserService userA;

    @RequestMapping(value="/all", method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void greeting1() {
        userA.saveUser();
    }
}

