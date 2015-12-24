package rl.signaltable.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import rl.signaltable.core.entity.ProcessControlObject;
import rl.signaltable.core.entity.AnalogInput;
import rl.signaltable.service.ProcessControlObjectService;
import rl.signaltable.service.AnalogInputService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AnalogInputController {

    @Autowired
    private AnalogInputService analogInputService;

    @Autowired
    private ProcessControlObjectService processControlObjectService;

}
