package courseProject.controllers;

import courseProject.persistence.dao.services.interfaces.RoleService;
import courseProject.persistence.dao.services.interfaces.UserDetailsService;
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

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration/add")
    public String addNewUser(HttpServletRequest request) {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword("{noop}" + request.getParameter("password"));
        Role role = new Role("ROLE_USER", user.getLogin());
        user.setRoles(Collections.singletonList(role));
        userDetailsService.addUser(user);
        roleService.addRole(role);
        return "redirect:/login";
    }
}
