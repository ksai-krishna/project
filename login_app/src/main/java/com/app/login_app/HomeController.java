package com.app.login_app;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        return "home";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
