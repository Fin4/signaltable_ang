package rldev.signaltable;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rldev.signaltable.configuration.AppConfig;
import rldev.signaltable.dao.DigitalInputDao;
import rldev.signaltable.entity.DigitalInput;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DigitalInputDaoTests {

    @Autowired private DigitalInputDao digitalInputDao;

    @Ignore
    @Test
    public void getPcObjectOfDigitalInput() {
        DigitalInput digitalInput = digitalInputDao.getById((long) 56);
        System.out.println(digitalInput);
        System.out.println(digitalInput.getProcessControlObject().getDepartment());
    }
}
