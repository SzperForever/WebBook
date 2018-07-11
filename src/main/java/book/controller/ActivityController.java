package book.controller;

import book.service.LoginService;
import book.vo.MsgInfo;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActivityController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value="/Login", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo Login(String userName, String password)
    {
        System.out.println("user: " + userName + " pass: " + password);
        MsgInfo msgInfo = new MsgInfo();
        try{
            loginService.Login(userName, password);
            msgInfo.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            msgInfo.setCode(0);
            msgInfo.setMsg(e.getMessage());
        }
        return msgInfo;
    }

}
