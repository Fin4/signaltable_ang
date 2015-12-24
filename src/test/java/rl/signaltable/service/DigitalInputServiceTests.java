package rl.signaltable.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rl.signaltable.configuration.AppConfig;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DigitalInputServiceTests {

    @Autowired private DigitalInputService digitalInputService;

    @Test public void getByIdTest() {
        digitalInputService.getById((long) 2);
    }
}
