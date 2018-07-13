package book.controller;

import book.model.User;
import book.service.UserService;
import book.vo.MsgInfo;
import book.vo.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> loginAuth(String username, String password, HttpSession httpSession) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            User user = userService.loginAuth(username, password);
            httpSession.setAttribute("user", user);
            hashMap.put("state", "success");
        } catch (Exception e) {
            hashMap.put("state", "fail");
            e.printStackTrace();
            hashMap.put("reason", e.getMessage());
        } finally {
            return hashMap;
        }
    }
    @RequestMapping(value = "registerAuth", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo registerAuth(UserJson userJson){
        MsgInfo msgInfo = new MsgInfo();
        try{
            User user = User.newInsertInstance(userJson.getUsername(), userJson.getPassword(), userJson.getEmail());
            if(userService.registerAuth(user) == true){
                msgInfo.setCode(1);
                msgInfo.setMsg("注册成功");
            };
        }catch (Exception e){
            //e.printStackTrace();
            msgInfo.setMsg(e.getMessage());
            msgInfo.setCode(0);
        }
        return msgInfo;
    }


}
