package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.ProcessControlObject;
import rldev.signaltable.entity.DigitalOutput;
import rldev.signaltable.service.ProcessControlObjectService;
import rldev.signaltable.service.DigitalOutputService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class DigitalOutputController {

    @Autowired DigitalOutputService digitalOutputService;
    @Autowired ProcessControlObjectService processControlObjectService;

    /* ************************************************************add new DO************************************************************ */
    @RequestMapping(value = {"/{objName}/do/new"}, method = RequestMethod.GET)
    public String newDigitalOutput(@PathVariable String objName, ModelMap modelMap) {
        DigitalOutput digitalOutput = new DigitalOutput();

        modelMap.addAttribute("digitalOutput", digitalOutput);

        return "signaltable/DOs/newDO";
    }

    @RequestMapping(value = {"/{objName}/do/new"}, method = RequestMethod.POST)
    public String saveDigitalOutput(@Valid DigitalOutput digitalOutput, @PathVariable String objName, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/DOs/newDO";

        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);
        digitalOutput.setProcessControlObject(processControlObject);

        digitalOutputService.save(digitalOutput);

        return "redirect:/{objName}/do";
    }

    /* ************************************************************edit existing DO************************************************************ */
    @RequestMapping(value = {"/{objName}/do/{doId}-edit"}, method = RequestMethod.GET)
    public String editDigitalOutput(@PathVariable String objName, @PathVariable Long doId, ModelMap modelMap) {

        DigitalOutput digitalOutput = digitalOutputService.getById(doId);

        modelMap.addAttribute("digitalOutput", digitalOutput);

        return "signaltable/DOs/newDO";
    }

    @RequestMapping(value = {"/{objName}/do/{doId}-edit"}, method = RequestMethod.POST)
    public String updateDigitalOutput(@Valid DigitalOutput digitalOutput, @PathVariable String objName,
                                     @PathVariable Long doId, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/DOs/newDO";

        digitalOutput.setId(doId);

        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);
        digitalOutput.setProcessControlObject(processControlObject);

        digitalOutputService.update(digitalOutput);

        return "redirect:/{objName}/do";
    }

    /* ************************************************************delete existing DO************************************************************ */
    @RequestMapping(value = {"/{objName}/do/{doId}-delete"}, method = RequestMethod.POST)
    public String deleteDigitalOutput(@PathVariable String objName, @PathVariable Long doId) {
        digitalOutputService.deleteById(doId);
        return "redirect:/{objName}/do";
    }

    /* ************************************************************show all by Object************************************************************ */
    @RequestMapping(value = {"/{objName}/do"}, method = RequestMethod.GET)
    public String allObjectAI(@PathVariable String objName, ModelMap modelMap) {
        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);

        List<DigitalOutput> digitalOutputs = digitalOutputService.getByProcessControlObjectName(objName);

        modelMap.addAttribute("digitalOutputs", digitalOutputs);
        modelMap.addAttribute("apcsObject", processControlObject);

        return "signaltable/DOs/objectDOs";
    }
}
