package rldev.signaltable;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rldev.signaltable.configuration.AppConfig;
import rldev.signaltable.dao.ProcessControlObjectDao;

import java.util.List;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessControlObjectTest {

    @Autowired private ProcessControlObjectDao processControlObjectDao;

    @Ignore
    @Test
    public void findByDepartmentName() {
        List objs = processControlObjectDao.getByDepartmentName("Sugar");
        System.out.println(objs);
    }
}
