package courseProject.controllers;

import courseProject.persistence.dao.services.interfaces.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @GetMapping(value = "/profile")
    public ModelAndView profile(ModelAndView modelAndView) {
        String userName;
        userName = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("profile", profileService.findProfileByUserName(userName));
        modelAndView.setViewName("profile");

        return modelAndView;
    }
}
