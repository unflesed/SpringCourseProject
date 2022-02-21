package courseProject.controllers;

import courseProject.persistence.dao.services.interfaces.ProfileService;
import courseProject.persistence.dao.services.interfaces.RoleService;
import courseProject.persistence.dao.services.interfaces.UserDetailsService;
import courseProject.persistence.model.Profile;
import courseProject.persistence.model.Role;
import courseProject.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ProfileService profileService;

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration/add")
    public String addNewUser(HttpServletRequest request) {
        User user = new User();
        Profile profile = new Profile();

        profile.setFirstName(request.getParameter("First Name"));
        profile.setLastName(request.getParameter("Last Name"));
        profile.setPhone(request.getParameter("phone"));
        profile.setEmail(request.getParameter("email"));

        profile = profileService.saveProfile(profile.getFirstName(), profile.getLastName(),
                profile.getPhone(), profile.getEmail());

        user.setLogin(request.getParameter("login"));
        user.setPassword("{noop}" + request.getParameter("password"));
        Role role = new Role("ROLE_USER", user.getLogin());
        user.setRoles(Collections.singletonList(role));
        user.setProfile(profile);

        userDetailsService.addUser(user);
        roleService.addRole(role);
        return "redirect:/login";
    }
}
