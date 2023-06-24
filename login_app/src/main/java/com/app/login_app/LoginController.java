package com.app.login_app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("errorMessage", "");
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userRepository.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("errorMessage", "Wrong username or password!");
            return "login";
        }

        session.setAttribute("user", user);
        return "redirect:/home";
    }
}