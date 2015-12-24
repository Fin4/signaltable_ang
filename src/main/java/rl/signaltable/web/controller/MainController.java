package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public @ResponseBody List<DigitalInput> youAreWelcome() {

        List<DigitalInput> digitalInputs = digitalInputService.getByProcessControlObjectId((long) 4);
        return digitalInputs;
    }
}
