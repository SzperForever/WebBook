package book.controller;

import book.model.User;
import book.service.UserService;
import book.vo.MsgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import book.vo.UserJson;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

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
            hashMap.put("state", "success");
            hashMap.put("reason", user.getId()+"");
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

    @RequestMapping(value = "lockUser", method = RequestMethod.POST)
    @ResponseBody
    public void lockStatus(String username){

        userService.updateUser(User.newLockInstance(userService.getUserByName(username).getId(),3));

    }
    @RequestMapping(value = "getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(value = "unlockUser")
    @ResponseBody
    public MsgInfo unlockUser(int userId){
        MsgInfo msgInfo = new MsgInfo();
        try{
            userService.unlockUser(userId);
            msgInfo.setCode(1);
            msgInfo.setMsg("解锁成功");
        }catch (Exception e){
            e.printStackTrace();
            msgInfo.setCode(0);
            msgInfo.setMsg(e.getMessage());
        }
        return msgInfo;
    }
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo deleteUser(int userId){
        MsgInfo msgInfo = new MsgInfo();
        try {
            userService.deleteUser(userId);
            msgInfo.setCode(1);
            msgInfo.setMsg("删除用户成功");
        }catch (Exception e){
            e.printStackTrace();
            msgInfo.setCode(0);
            msgInfo.setMsg(e.getMessage());
        }
        return msgInfo;
    }

}
