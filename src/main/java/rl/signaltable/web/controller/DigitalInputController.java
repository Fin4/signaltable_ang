package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rl.signaltable.core.entity.DigitalInput;
import rl.signaltable.service.DigitalInputService;
import rl.signaltable.core.entity.ProcessControlObject;
import rl.signaltable.service.ProcessControlObjectService;

import java.util.List;

@RestController
public class DigitalInputController {

    @Autowired
    DigitalInputService digitalInputService;

    @Autowired
    ProcessControlObjectService processControlObjectService;

    @RequestMapping(value = {"/{objName}/di{diId}"}, method = RequestMethod.GET)
    public Object getDigitalInput(@RequestBody DigitalInput digitalInput, @PathVariable String objName, @PathVariable Long diId) {
        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);
        digitalInput.setProcessControlObject(processControlObject);
        digitalInputService.update(digitalInput);
        return digitalInput;
    }

    /**
     * create new digital input
     */
    @RequestMapping(value = {"/{objName}/di/new"}, method = RequestMethod.POST)
    public Object createDigitalInput(@PathVariable String objName) {
        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);
        DigitalInput digitalInput = new DigitalInput();
        digitalInput.setProcessControlObject(processControlObject);
        digitalInputService.save(digitalInput);
        return digitalInput;
    }

    @RequestMapping(value = {"/{objName}/di{diId}"}, method = RequestMethod.POST)
    public Object updateDigitalInput(@RequestBody DigitalInput digitalInput, @PathVariable String objName, @PathVariable Long diId) {
        ProcessControlObject processControlObject = processControlObjectService.getByName(objName);
        digitalInput.setProcessControlObject(processControlObject);
        digitalInputService.update(digitalInput);
        return digitalInput;
    }

    @RequestMapping(value = {"/{objName}/di{diId}-delete"}, method = RequestMethod.POST)
    public Object deleteDigitalInput(@PathVariable String objName, @PathVariable Long diId) {
        digitalInputService.deleteById(diId);
        return "removed";
    }

    @RequestMapping(value = {"/{objName}/di"}, method = RequestMethod.GET)
    public Object allPcObjectDI(@PathVariable String objName) {

        List<DigitalInput> digitalInputs = digitalInputService.getByProcessControlObjectName(objName);
        return digitalInputs;
    }
}
