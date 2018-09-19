package kisit.group471.controllers;


import kisit.group471.model.User;
import kisit.group471.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String getRegistration() {

        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(@RequestParam User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
