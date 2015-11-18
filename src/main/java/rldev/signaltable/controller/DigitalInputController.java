package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.DigitalInput;
import rldev.signaltable.service.APCSObjectService;
import rldev.signaltable.service.DigitalInputService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class DigitalInputController {

    @Autowired
    DigitalInputService digitalInputService;

    @Autowired
    APCSObjectService apcsObjectService;

    /* ************************************************************add new DI************************************************************ */
    @RequestMapping(value = {"/{objName}/di/new"}, method = RequestMethod.GET)
    public String newDigitalInput(@PathVariable String objName, ModelMap modelMap) {
        DigitalInput digitalInput = new DigitalInput();

        modelMap.addAttribute("digitalInput", digitalInput);

        return "signaltable/DIs/newDI";
    }

    @RequestMapping(value = {"/{objName}/di/new"}, method = RequestMethod.POST)
    public String saveDigitalInput(@Valid DigitalInput digitalInput, @PathVariable String objName, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/DIs/newDI";

        APCSObject apcsObject = apcsObjectService.getByName(objName);
        digitalInput.setApcsObject(apcsObject);

        digitalInputService.save(digitalInput);

        return "redirect:/{objName}/di";
    }

    /* ************************************************************edit existing DI************************************************************ */
    @RequestMapping(value = {"/{objName}/di/{diId}-edit"}, method = RequestMethod.GET)
    public String editDigitalInput(@PathVariable String objName, @PathVariable Long diId, ModelMap modelMap) {

        DigitalInput digitalInput = digitalInputService.getById(diId);

        modelMap.addAttribute("digitalInput", digitalInput);

        return "signaltable/DIs/newDI";
    }

    @RequestMapping(value = {"/{objName}/di/{diId}-edit"}, method = RequestMethod.POST)
    public String updateDigitalInput(@Valid DigitalInput digitalInput, @PathVariable String objName,
                                     @PathVariable Long diId, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/DIs/newDI";

        digitalInput.setId(diId);

        APCSObject apcsObject = apcsObjectService.getByName(objName);
        digitalInput.setApcsObject(apcsObject);

        digitalInputService.update(digitalInput);

        return "redirect:/{objName}/di";
    }

    /* ************************************************************delete existing DI************************************************************ */
    @RequestMapping(value = {"/{objName}/di/{diId}-delete"}, method = RequestMethod.POST)
    public String deleteDigitalInput(@PathVariable String objName, @PathVariable Long diId) {
        digitalInputService.deleteById(diId);
        return "redirect:/{objName}/di";
    }

    /* ************************************************************show all by Object************************************************************ */
    @RequestMapping(value = {"/{objName}/di"}, method = RequestMethod.GET)
    public String allObjectDI(@PathVariable String objName, ModelMap modelMap) {

        APCSObject apcsObject = apcsObjectService.getByName(objName);

        List<DigitalInput> digitalInputs = digitalInputService.getByAPCSObjectName(objName);

        modelMap.addAttribute("digitalInputs", digitalInputs);
        modelMap.addAttribute("apcsObject", apcsObject);

        return "signaltable/DIs/objectDIs";
    }
}
