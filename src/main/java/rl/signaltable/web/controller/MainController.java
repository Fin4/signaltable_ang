package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rl.signaltable.core.entity.DigitalInput;
import rl.signaltable.service.DigitalInputService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DigitalInputService digitalInputService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public @ResponseBody Object youAreWelcome() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "you are welcome " + authentication.getName();
    }

    public MainController(DigitalInputService digitalInputService) {
        this.digitalInputService = digitalInputService;
    }

    public MainController() {}
}
