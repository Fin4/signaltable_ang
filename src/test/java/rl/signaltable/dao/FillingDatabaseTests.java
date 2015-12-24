package rl.signaltable.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rl.signaltable.core.entity.*;
import rl.signaltable.service.*;
import rl.signaltable.configuration.AppConfig;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FillingDatabaseTests {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    ProcessControlObjectService processControlObjectService;
    @Autowired
    DigitalInputService digitalInputService;
    @Autowired
    AnalogInputService analogInputService;
    @Autowired
    DigitalOutputService digitalOutputService;
    @Autowired AnalogOutputService analogOutputService;

    @Rollback(value = false)
    @Ignore
    @Test public void fill1(){

        Department department = new Department();
        department.setName("TestDepartment");
        department.setDescription("It's created just for app testing");
        departmentService.save(department);

        ProcessControlObject pcObject = new ProcessControlObject();
        pcObject.setName("TestPcObject");
        pcObject.setDescription("It's created just for app testing");
        pcObject.setSymbol("T");
        pcObject.setDepartment(department);
        processControlObjectService.save(pcObject);

        for (int i = 1 ; i <= 50; i++) {
            DigitalInput digitalInput = new DigitalInput();
            digitalInput.setSymbol("K" + i);
            digitalInput.setDescription("DI description " + i);
            digitalInput.setProcessControlObject(pcObject);
            digitalInputService.save(digitalInput);

            AnalogInput analogInput = new AnalogInput();
            analogInput.setSymbol("L" + i);
            analogInput.setDescription("AI description " + i);
            analogInput.setProcessControlObject(pcObject);
            analogInputService.save(analogInput);


            AnalogOutput analogOutput = new AnalogOutput();
            analogOutput.setSymbol("Ef" + i);
            analogOutput.setDescription("AO description " + i);
            analogOutput.setProcessControlObject(pcObject);
            analogOutputService.save(analogOutput);

            DigitalOutput digitalOutput = new DigitalOutput();
            digitalOutput.setSymbol("KZ" + i);
            digitalOutput.setDescription("DO description " + i);
            digitalOutput.setProcessControlObject(pcObject);
            digitalOutputService.save(digitalOutput);
        }
    }
}
