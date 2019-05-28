package com.rock;

import com.rock.bean.Friend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {

    @Autowired
    Friend friend;

    @Test
    public void contextLoads() {
        System.out.println(friend.toString());
    }

}
