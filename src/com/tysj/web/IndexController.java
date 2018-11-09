package com.tysj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2018/11/9 20:54
 * @Created by xzcawl
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index.do")
    public String index(){
        return "guestInformation.html";
    }

}
