package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.Direction;
import rldev.signaltable.service.DirectionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class DirectionController {

    @Autowired
    DirectionService directionService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listDirections(ModelMap modelMap) {
        List<Direction> directions = directionService.getAll();
        modelMap.addAttribute("directions", directions);

        return "signaltable/Direction/directions";
    }

    @RequestMapping(value = {"/newDirection"}, method = RequestMethod.GET)
    public String newDirection(ModelMap modelMap) {
        Direction direction = new Direction();
        modelMap.addAttribute("direction", direction);
        return "newDirection";
    }

    @RequestMapping(value = {"/newDirection"}, method = RequestMethod.POST)
    public String saveDirection(@Valid Direction direction, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) return "newDirection";

        directionService.save(direction);

        //modelMap.addAttribute("success", "Direction " + Direction.toString() + " successfully added");
        return "redirect:/listDirections";
    }
}
