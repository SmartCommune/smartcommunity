package kisit.group471.service;

import kisit.group471.model.Role;
import kisit.group471.model.State;
import kisit.group471.model.User;
import kisit.group471.repositories.UserRepository;
import kisit.group471.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements RegistrationService<UserDto> {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registration(UserDto model) {
        String hashPassword = passwordEncoder.encode(model.getPassword());
        User user = new User(
                model.getLogin(),
                hashPassword,
                Role.USER,
                State.ACTIVE
        );
        userRepository.save(user);
    }
}
