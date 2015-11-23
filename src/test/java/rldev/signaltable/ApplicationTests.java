package rldev.signaltable;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rldev.signaltable.configuration.AppConfiguration;
import rldev.signaltable.dao.UserRepository;
import rldev.signaltable.entity.*;
import rldev.signaltable.service.*;

@ContextConfiguration(classes = AppConfiguration.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTests {

    @Autowired APCSObjectService apcsObjectService;
    @Autowired DirectionService directionService;
    @Autowired DigitalInputService digitalInputService;
    @Autowired DigitalOutputService digitalOutputService;
    @Autowired AnalogInputService analogInputService;
    @Autowired AnalogOutputService analogOutputService;

    @Ignore
    @Test
    @Rollback(value = false)
    public void createTestObject() {

        Direction tdirection = new Direction();
        tdirection.setName("TestDirection");
        directionService.save(tdirection);

        Direction direction = directionService.getDirectionByName("TestDirection");

        APCSObject apcsObject = new APCSObject();
        apcsObject.setName("TestControlObject1");
        apcsObject.setSymbol("T1");
        apcsObject.setDescription(apcsObject.getName() + " description");
        apcsObject.setDirection(direction);
        apcsObjectService.save(apcsObject);

        int i = 1;

        APCSObject obj = apcsObjectService.getBySymbol("T1");

        while (i <= 50) {
            DigitalInput digitalInput = new DigitalInput("T1_DI" + i, "T1_DI" + i + " description", obj);
            digitalInputService.save(digitalInput);

            DigitalOutput digitalOutput = new DigitalOutput("T1_DO" + i, "T1_DO" + i + " description", obj);
            digitalOutputService.save(digitalOutput);

            AnalogInput analogInput = new AnalogInput("T1_AI" + i, "T1_AI" + i + " description", obj);
            analogInputService.save(analogInput);

            AnalogOutput analogOutput = new AnalogOutput("T1_AO" + i, "T1_AO" + i + " description", obj);
            analogOutputService.save(analogOutput);

            i++;
        }
    }

    @Ignore
    @Test
    public void getBigData() {
        APCSObject apcsObject = apcsObjectService.getBySymbol("T1");

        System.out.println(apcsObject.getDigitalInputs());
    }

    @Ignore
    @Test
    public void getAPCSDIs(){
        System.out.println(digitalInputService.getByAPCSObjectId((long)5));
    }

    @Test
    public void addUser() {

    }
}
