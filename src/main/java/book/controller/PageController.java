package book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/")
    public String getIndex2(){
        return "index";
    }

    @RequestMapping("/chart")
    public String getChart(){
        return "chart";
    }

    @RequestMapping("/order")
    public String getOrder(){
        return "order";
    }

}
