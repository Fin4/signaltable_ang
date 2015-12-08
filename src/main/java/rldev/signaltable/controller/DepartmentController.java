package rldev.signaltable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rldev.signaltable.entity.Department;
import rldev.signaltable.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class DepartmentController {

    @Autowired DepartmentService DepartmentService;

    @RequestMapping(value = {"/newDepartment"}, method = RequestMethod.GET)
    public String newDepartment(ModelMap modelMap) {
        Department department = new Department();
        modelMap.addAttribute("Department", department);
        return "newDepartment";
    }

    @RequestMapping(value = {"/newDepartment"}, method = RequestMethod.POST)
    public String saveDepartment(@Valid Department department, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) return "newDepartment";

        DepartmentService.save(department);

        //modelMap.addAttribute("success", "Department " + Department.toString() + " successfully added");
        return "redirect:/listDepartments";
    }
}
