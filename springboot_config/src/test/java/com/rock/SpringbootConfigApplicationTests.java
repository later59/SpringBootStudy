package com.rock;

import com.rock.bean.Person;
import com.rock.bean.PersonValue;
import com.rock.bean.PersonSourceBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    PersonValue personValue;

    @Autowired
    PersonSourceBean personSourceBean;

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        //System.out.println(personSourceBean.toString());
        //System.out.println(context.containsBean("importResourceService"));
        System.out.println(person);
    }

}
