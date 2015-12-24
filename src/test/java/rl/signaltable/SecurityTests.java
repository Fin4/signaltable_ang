package rl.signaltable;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rl.signaltable.configuration.AppConfig;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class SecurityTests {

    @Autowired
    UserDetailsService userDetailsService;

}
