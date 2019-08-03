package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/31 19:04
 * @Description: Frighting!!!
 */

@Controller
public class UserController {


    @PostMapping("login")
    public String main(HttpSession session, String name){

        session.setAttribute("user",name);

        return "main";
    }
}
