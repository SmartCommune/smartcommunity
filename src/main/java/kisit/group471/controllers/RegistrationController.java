package kisit.group471.controllers;


import kisit.group471.model.User;
import kisit.group471.repositories.UserRepository;
import kisit.group471.service.RegistrationService;
import kisit.group471.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final RegistrationService userRepository;

    @Autowired
    public RegistrationController(RegistrationService userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String getRegistration() {

        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(UserDto userDto) {
        userRepository.registration(userDto);
        return "redirect:/";
    }
}
