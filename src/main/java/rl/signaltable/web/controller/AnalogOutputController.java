package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rl.signaltable.core.entity.AnalogOutput;
import rl.signaltable.core.entity.ProcessControlObject;
import rl.signaltable.service.ProcessControlObjectService;
import rl.signaltable.service.AnalogOutputService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnalogOutputController {

    @Autowired
    private AnalogOutputService analogOutputService;

    @Autowired
    private ProcessControlObjectService processControlObjectService;

}
