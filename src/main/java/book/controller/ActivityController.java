package book.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ActivityController {
    /*@Autowired
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
    }*/

}
