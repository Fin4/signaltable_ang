package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import rldev.signaltable.entity.*;
import rldev.signaltable.service.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class APCSObjectController {

    @Autowired
    private APCSObjectService apcsObjectService;
    @Autowired
    private DigitalInputService digitalInputService;
    @Autowired
    private DigitalOutputService digitalOutputService;
    @Autowired
    private AnalogInputService analogInputService;
    @Autowired
    AnalogOutputService analogOutputService;

    @RequestMapping(value = {"/{dirName}"}, method = RequestMethod.GET)
    public String directionObjects(ModelMap modelMap, @PathVariable String dirName) {
        List<APCSObject> apcsObjects = apcsObjectService.getAllObjectsByDirectionName(dirName);
        modelMap.addAttribute("apcsObjects", apcsObjects);
        return "signaltable/APCSObject/objs";
    }

    /* ************************************************************Download excel************************************************************ */
    @RequestMapping(value = "/{objName}-downloadExcel", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@PathVariable String objName) {

        APCSObject apcsObject = apcsObjectService.getByName(objName);

        apcsObject.setDigitalInputList(digitalInputService.getByAPCSObjectName(objName));
        apcsObject.setAnalogInputList(analogInputService.getByAPCSObjectName(objName));
        apcsObject.setDigitalOutputList(digitalOutputService.getByAPCSObjectName(objName));
        apcsObject.setAnalogOutputList(analogOutputService.getByAPCSObjectName(objName));

        return new ModelAndView("excelView", "apcsObject", apcsObject);
    }
}
