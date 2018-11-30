package sunjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: sunjx
 * @Date: 2018/11/30 0030 15:07
 * @Description:
 */
@Controller
public class MainController {

    @ResponseBody
    @RequestMapping("")
    public String index(){
        return "123";
    }
}
