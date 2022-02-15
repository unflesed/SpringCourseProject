package courseProject.controllers;

import courseProject.persistence.dao.services.interfaces.JournalService;
import courseProject.persistence.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping(value = "/all")
    public ModelAndView listAllJournals(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("journals", journalService.findAll());
        modelAndView.setViewName("journals");
        return modelAndView;
    }

    @GetMapping(value = "subscriptions")
    public ModelAndView listAllSubscriptions(ModelAndView modelAndView) throws InterruptedException {
        String userName;
        userName = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("journals", journalService.findAllByUserName(userName));
        modelAndView.setViewName("subscriptions");
        return modelAndView;
    }

    @GetMapping(value = "/remove/{id}")
    public ModelAndView deleteJournal(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        journalService.removeById(id);
        modelAndView.setViewName("redirect:/journal/all");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewJournal(HttpServletRequest request) {
        Journal journal = new Journal();
        journal.setJournalName(request.getParameter("journalName"));
        journal.setGenre(request.getParameter("genre"));
        journal.setPeriodicity(request.getParameter("periodicity"));
        journal.setCost(Integer.parseInt(request.getParameter("cost")));
        journalService.addJournal(journal);
        return "redirect:/journal/all";
    }

    @PostMapping(value = "/update")
    public ModelAndView updateJournal(@RequestParam("id") long id, @RequestParam("journalName") String journalName,
                                      @RequestParam("genre") String genre,
                                      @RequestParam("periodicity") String periodicity,
                                      @RequestParam("cost") int cost,
                                      ModelAndView modelAndView) throws InterruptedException {
        journalService.updateJournal(id, journalName, genre, periodicity, cost);
        modelAndView.setViewName("redirect:/journal/all");
        return modelAndView;
    }
    @PostMapping(value = "/findByGenre")
    public ModelAndView findJournalByGenre(@RequestParam("genre") String genre, ModelAndView modelAndView) {

        modelAndView.addObject("journals", journalService.findJournalByGenre(genre));
        modelAndView.setViewName("/results");

        return modelAndView;
    }
    @PostMapping(value = "/subscribe/{id}")
    public String subscribe(@PathVariable long id) {
        String userName;
        userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!journalService.checkSubscription(userName, id)) {
            journalService.subscribeJournal(userName, id);
            return "redirect:/journal/all";
        }
        return "subscribed";
    }

    @PostMapping(value = "/unsubscribe/{id}")
    public String unSubscribe(@PathVariable long id) {
        String userName;
        userName = SecurityContextHolder.getContext().getAuthentication().getName();
        journalService.unSubscribeJournal(userName, id);
        return "unsubscribed";
    }

    @GetMapping(value = "/popup")
    public String popup(){
        return "popup";
    }
}
