package book.controller;

import book.model.User;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/logOut", method = RequestMethod.POST)
    @ResponseBody
    public String logOut(HttpSession httpSession){
        httpSession.setAttribute("user",null);
        return "Success";
    }

}
