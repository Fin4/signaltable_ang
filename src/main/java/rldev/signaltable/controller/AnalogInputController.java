package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.AnalogInput;
import rldev.signaltable.service.APCSObjectService;
import rldev.signaltable.service.AnalogInputService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AnalogInputController {

    @Autowired
    private AnalogInputService analogInputService;

    @Autowired
    private APCSObjectService apcsObjectService;

    /* ************************************************************add new AI************************************************************ */
    @RequestMapping(value = {"/{objName}/ai/new"}, method = RequestMethod.GET)
    public String newAnalogInput(@PathVariable String objName, ModelMap modelMap) {
        AnalogInput analogInput = new AnalogInput();

        modelMap.addAttribute("analogInput", analogInput);

        return "signaltable/AIs/newAI";
    }

    @RequestMapping(value = {"/{objName}/ai/new"}, method = RequestMethod.POST)
    public String saveAnalogInput(@Valid AnalogInput analogInput, @PathVariable String objName, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/AIs/newAI";

        APCSObject apcsObject = apcsObjectService.getByName(objName);
        analogInput.setApcsObject(apcsObject);

        analogInputService.save(analogInput);

        return "redirect:/{objName}/ai";
    }

    /* ************************************************************edit existing DI************************************************************ */
    @RequestMapping(value = {"/{objName}/ai/{aiId}-edit"}, method = RequestMethod.GET)
    public String editAnalogInput(@PathVariable String objName, @PathVariable Long aiId, ModelMap modelMap) {

        AnalogInput analogInput = analogInputService.getById(aiId);

        modelMap.addAttribute("analogInput", analogInput);

        return "signaltable/AIs/newAI";
    }

    @RequestMapping(value = {"/{objName}/ai/{aiId}-edit"}, method = RequestMethod.POST)
    public String updateAnalogInput(@Valid AnalogInput analogInput, @PathVariable String objName,
                                    @PathVariable Long aiId, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/AIs/newAI";

        analogInput.setId(aiId);

        APCSObject apcsObject = apcsObjectService.getByName(objName);
        analogInput.setApcsObject(apcsObject);

        analogInputService.update(analogInput);

        return "redirect:/{objName}/ai";
    }

    /* ************************************************************delete existing DI************************************************************ */
    @RequestMapping(value = {"/{objName}/ai/{aiId}-delete"}, method = RequestMethod.POST)
    public String deleteAnalogInput(@PathVariable String objName, @PathVariable Long aiId) {
        analogInputService.deleteById(aiId);
        return "redirect:/{objName}/ai";
    }

    /* ************************************************************show all by Object************************************************************ */
    @RequestMapping(value = {"/{objName}/ai"}, method = RequestMethod.GET)
    public String allObjectAI(@PathVariable String objName, ModelMap modelMap) {
        APCSObject apcsObject = apcsObjectService.getByName(objName);

        List<AnalogInput> analogInputs = analogInputService.getByAPCSObjectName(objName);

        modelMap.addAttribute("analogInputs", analogInputs);
        modelMap.addAttribute("apcsObject", apcsObject);

        return "signaltable/AIs/objectAIs";
    }

}
