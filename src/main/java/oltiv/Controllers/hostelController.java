package oltiv.Controllers;

import oltiv.business.FlankRooms;
import oltiv.business.Hostel;
import oltiv.business.HostelFlank;
import oltiv.service.Interface.HostelService;
import oltiv.service.Interface.PraptiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hostel")
public class hostelController {

    @Autowired
    HostelService hostelSvc;

    @RequestMapping(value="/getAllHostels", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Hostel> getAllHostels() {
        List<Hostel> hostels= hostelSvc.getAllHostels();
        return hostels;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createHostel(@RequestBody Hostel hostelDetail) {   ///Recieving details from front end
        hostelSvc.createHostel(hostelDetail);
    }

    @RequestMapping(value="/createFlank", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createFlank(@RequestBody HostelFlank flankDetail) {   ///Recieving details from front end
        hostelSvc.createFlank(flankDetail);
    }

    @RequestMapping(value="/getHostelFlanks/{hostelId}",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HostelFlank> getHostelFlanks(@PathVariable int hostelId) {
        return hostelSvc.getHostelsFlank(hostelId);
    }

    @RequestMapping(value="/getFlankRooms/{flankName}",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FlankRooms> getFlankRooms(@PathVariable String flankName) {
        return hostelSvc.getFlankRooms(flankName);
    }
}
