package kisit.group471.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {


    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }
}
