package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.Direction;
import rldev.signaltable.service.APCSObjectService;
import rldev.signaltable.service.DirectionService;

import java.util.List;

@Controller
@RequestMapping(value = "/", method = {})
public class MainController {

    @Autowired
    private DirectionService directionService;

    @Autowired
    private APCSObjectService apcsObjectService;

    /*@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listDirections(ModelMap modelMap) {
        List<Direction> directions = directionService.getAll();
        modelMap.addAttribute("directions", directions);
        return "main";
    }*/

    @RequestMapping(value = {"/signals"}, method = RequestMethod.GET)
    public String buildTable(ModelMap modelMap) {
        List<Direction> directions = directionService.getAll();
        modelMap.addAttribute("directions", directions);

        return "signals";
    }

    @RequestMapping(value = {"/{id}-apcsObject"}, method = RequestMethod.GET)
    public String showApcsObject(@PathVariable Long id, ModelMap modelMap) {
        APCSObject apcsObject = apcsObjectService.getById(id);
        modelMap.addAttribute("apcsObject", apcsObject);

        return "signals";
    }
}
