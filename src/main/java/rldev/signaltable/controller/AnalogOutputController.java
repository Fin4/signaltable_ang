package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.AnalogOutput;
import rldev.signaltable.service.APCSObjectService;
import rldev.signaltable.service.AnalogOutputService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AnalogOutputController {

    @Autowired
    private AnalogOutputService analogOutputService;

    @Autowired
    private APCSObjectService apcsObjectService;

    /* ************************************************************add new AO************************************************************ */
    @RequestMapping(value = {"/{objName}/ao/new"}, method = RequestMethod.GET)
    public String newAnalogOutput(@PathVariable String objName, ModelMap modelMap) {
        AnalogOutput analogOutput = new AnalogOutput();

        modelMap.addAttribute("analogOutput", analogOutput);

        return "signaltable/AOs/newAO";
    }

    @RequestMapping(value = {"/{objName}/ao/new"}, method = RequestMethod.POST)
    public String saveAnalogOutput(@Valid AnalogOutput analogOutput, @PathVariable String objName, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/AOs/newAO";

        APCSObject apcsObject = apcsObjectService.getByName(objName);
        analogOutput.setApcsObject(apcsObject);

        analogOutputService.save(analogOutput);

        return "redirect:/{objName}/ao";
    }

    /* ************************************************************edit existing AO************************************************************ */
    @RequestMapping(value = {"/{objName}/ao/{aoId}-edit"}, method = RequestMethod.GET)
    public String eaotAnalogOutput(@PathVariable String objName, @PathVariable Long aoId, ModelMap modelMap) {

        AnalogOutput analogOutput = analogOutputService.getById(aoId);

        modelMap.addAttribute("analogOutput", analogOutput);

        return "signaltable/AOs/newAO";
    }

    @RequestMapping(value = {"/{objName}/ao/{aoId}-edit"}, method = RequestMethod.POST)
    public String updateAnalogOutput(@Valid AnalogOutput analogOutput, @PathVariable String objName,
                                     @PathVariable Long aoId, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) return "signaltable/AOs/newAO";

        analogOutput.setId(aoId);

        APCSObject apcsObject = apcsObjectService.getByName(objName);
        analogOutput.setApcsObject(apcsObject);

        analogOutputService.update(analogOutput);

        return "redirect:/{objName}/ao";
    }

    /* ************************************************************delete existing AO************************************************************ */
    @RequestMapping(value = {"/{objName}/ao/{aoId}-delete"}, method = RequestMethod.POST)
    public String deleteAnalogOutput(@PathVariable String objName, @PathVariable Long aoId) {
        analogOutputService.deleteById(aoId);
        return "redirect:/{objName}/ao";
    }

    /* ************************************************************show all by Object************************************************************ */
    @RequestMapping(value = {"/{objName}/ao"}, method = RequestMethod.GET)
    public String allObjectAO(@PathVariable String objName, ModelMap modelMap) {
        APCSObject apcsObject = apcsObjectService.getByName(objName);

        List<AnalogOutput> analogOutputs = analogOutputService.getByAPCSObjectName(objName);

        modelMap.addAttribute("analogOutputs", analogOutputs);
        modelMap.addAttribute("apcsObject", apcsObject);

        return "signaltable/AOs/objectAOs";
    }
}
