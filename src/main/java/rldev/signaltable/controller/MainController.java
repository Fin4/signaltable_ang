package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.ProcessControlObject;
import rldev.signaltable.entity.Department;
import rldev.signaltable.service.DepartmentService;
import rldev.signaltable.service.ProcessControlObjectService;

import java.util.List;

@Controller
@RequestMapping(value = "/", method = {})
public class MainController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProcessControlObjectService processControlObjectService;

    /*@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listDirections(ModelMap modelMap) {
        List<Department> directions = departmentService.getAll();
        modelMap.addAttribute("directions", directions);
        return "main";
    }*/

    @RequestMapping(value = {"/signals"}, method = RequestMethod.GET)
    public String buildTable(ModelMap modelMap) {
        List<Department> departments = departmentService.getAll();
        modelMap.addAttribute("departments", departments);

        return "signaltable/Department/departments";
    }

    @RequestMapping(value = {"/{id}-apcsObject"}, method = RequestMethod.GET)
    public String getProcessControlObject(@PathVariable Long id, ModelMap modelMap) {
        ProcessControlObject processControlObject = processControlObjectService.getById(id);
        modelMap.addAttribute("apcsObject", processControlObject);

        return "signals";
    }
}
