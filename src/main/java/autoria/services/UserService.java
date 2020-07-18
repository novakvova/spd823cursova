package autoria.services;

import net.javaguides.springbootsecurity.dto.UserRegistrationDto;
import autoria.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}