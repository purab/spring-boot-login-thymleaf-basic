package in.purabtech.logindemo.controller;

import in.purabtech.logindemo.model.Users;
import in.purabtech.logindemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Users());
        return "register_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users users) {
        System.out.println("reg request:"+users);
        Users regUser = usersService.registerUser(users.getLogin(),users.getPassword(),users.getEmail());
        return regUser == null ? "error_page" : "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest",new Users());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users users, Model model) {
        System.out.println("login request:"+users);
        Users loginUser = usersService.authenticate(users.getLogin(),users.getPassword());
        if (loginUser != null) {
            model.addAttribute("userLogin",loginUser.getLogin());
            return "mypage";
        } else {
            return "error_page";
        }

    }
}
