package book.controller;

import book.model.Address;
import book.service.AddressService;
import book.vo.MsgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/getAllAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<Address> getAllAddress(Integer userId){
        System.out.println(userId);
        return addressService.getAllAddressByUserId(userId);
    }
    @RequestMapping(value="/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo addAddress(Address address){
        MsgInfo msgInfo = new MsgInfo();
        if(address == null){
            msgInfo.setCode(0);
            msgInfo.setMsg("address is null");
        }
        if(addressService.addAddress(address) == false){
            msgInfo.setCode(0);
            msgInfo.setMsg("Add address failed");
        }
        else{
            msgInfo.setCode(1);
            msgInfo.setMsg("Success");
        }
        return msgInfo;

    }
}
