package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import rl.signaltable.core.entity.ProcessControlObject;
import rl.signaltable.service.*;

import java.util.List;

@RestController
public class ProcessControlObjectController {

    @Autowired private ProcessControlObjectService processControlObjectService;
    @Autowired private DigitalInputService digitalInputService;
    @Autowired private DigitalOutputService digitalOutputService;
    @Autowired private AnalogInputService analogInputService;
    @Autowired
    AnalogOutputService analogOutputService;

    @RequestMapping(value = {"/pcObject{id}"}, method = RequestMethod.GET)
    public Object getProcessControlObject(@PathVariable Long id) {
        return processControlObjectService.getById(id);
    }

    @RequestMapping(value = {"/{depName}"}, method = RequestMethod.GET)
    public Object departmentObjects(@PathVariable String depName) {
        List<ProcessControlObject> processControlObjects = processControlObjectService.getByDepartmentName(depName);
        return processControlObjects;
    }

    @RequestMapping(value = "/{objName}_signaltable.xls", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@PathVariable String objName) {

        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);

        processControlObject.setDigitalInputs(digitalInputService.getByProcessControlObjectName(objName));
        processControlObject.setAnalogInputs(analogInputService.getByProcessControlObjectName(objName));
        processControlObject.setDigitalOutputs(digitalOutputService.getByProcessControlObjectName(objName));
        processControlObject.setAnalogOutputs(analogOutputService.getByProcessControlObjectName(objName));

        return new ModelAndView("excelView", "processControlObject", processControlObject);
    }
}
