package autoria.web;


import autoria.entities.User;
import autoria.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import autoria.repositories.UserRepository;

import java.util.Arrays;

/**
 * @author Ramesh Fadatare
 *
 */
@Controller
public class AccountConroller
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String GetRegister()
    {
        return "register";
    }
    @PostMapping("/register")
    public String Register(User user)
    {
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        User u = new User();
        u.setPassword(pass);
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        //Role r = roleRepository.findByName("ROLE_USER");
//        Role r = new Role();
//        r.setId(3);

        u.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        userRepository.save(u);
        //messageRepository.save(message);
        return "redirect:/home";
    }
}