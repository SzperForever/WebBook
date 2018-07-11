package book.controller;

import book.model.Address;
import book.model.User;
import book.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/getAllAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<Address> getAllAddress(HttpSession httpSession){

        return addressService.getAllAddressByUserId(((User) httpSession.getAttribute("user")).getId());
    }
}
