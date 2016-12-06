package oltiv.Controllers;

import oltiv.service.Interface.PraptiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greeting")
public class PraptiController {

    @Autowired
    PraptiService praptiSvc;

    @RequestMapping(value="/prapti", method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void greeting1() {
        praptiSvc.addBoyFrndName();
    }

}
