package courseProject.controllers;

import courseProject.persistence.dao.services.interfaces.ProfileService;
import courseProject.persistence.dao.services.interfaces.UserDetailsService;
import courseProject.persistence.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @Autowired
    UserDetailsService userDetailsService;
    @GetMapping(value = "/my")
    public ModelAndView profile(ModelAndView modelAndView) {
        String userName;
        userName = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("profile", profileService.findProfileByUserName(userName));
        modelAndView.setViewName("profile");

        return modelAndView;
    }
    @PostMapping(value = "/update")
    public ModelAndView updateProfile(@RequestParam("firstName") String firstName,
                                      @RequestParam("lastName") String lastName,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("email") String email,
                                      ModelAndView modelAndView) {
        String userName;
        userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Profile profile = userDetailsService.getUserByLogin(userName).getProfile();
        profileService.updateProfile(profile.getId(), firstName, lastName, phone, email);

        modelAndView.setViewName("redirect:/profile/my");

        return modelAndView;
    }
}
