package rl.signaltable.dao;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rl.signaltable.configuration.AppConfig;
import rl.signaltable.core.dao.DigitalInputDao;
import rl.signaltable.core.entity.DigitalInput;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DigitalInputDaoTests {

    @Autowired private DigitalInputDao digitalInputDao;

    @Ignore
    @Test
    public void getDigitalInputById() {
        DigitalInput digitalInput = digitalInputDao.getById(56L);
        System.out.println(digitalInput);
        System.out.println(digitalInput.getProcessControlObject().getDepartment());
    }

    @Test
    public void getDigitalInputsByPcObjectId() {
        System.out.println(digitalInputDao.getByPcObjectId(4L));
    }

    @Test
    public void getDigitalInputsByPcObjectName() {
        System.out.println(digitalInputDao.getByPcObjectName("TestPcObject"));
    }

    @Test
    public void getDiPcObjectbyDiId() {
        DigitalInput digitalInput = digitalInputDao.getById(2l);
        System.out.println(digitalInput.getProcessControlObject());
    }
}
