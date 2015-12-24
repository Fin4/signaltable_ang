package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rl.signaltable.service.DepartmentService;
import rl.signaltable.core.entity.Department;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = {"/department{id}"}, method = RequestMethod.GET)
    public Object getDepartment(@PathVariable Long id) {
        return departmentService.getById(id);
    }

    @RequestMapping(value = {"/departments"}, method = RequestMethod.GET)
    public Object getAllDepartments(HttpServletRequest httpServletRequest) {
        return departmentService.getAll();
    }

    @RequestMapping(value = {"/newDepartment"}, method = RequestMethod.POST)
    public Object createDepartment(@RequestBody Department department, HttpServletRequest httpServletRequest) {
        departmentService.save(department);
        return department;
    }
}
