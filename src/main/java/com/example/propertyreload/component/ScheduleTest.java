package com.example.propertyreload.component;

import com.example.propertyreload.config.ReloadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Develop In Action.
 * <p>
 * create by: ryugwanghyen
 * create Time : 2017-10-13
 */
@Component
public class ScheduleTest {

    @Value("${test.reload}")
    private String propertyValue;

    @Autowired
    private ReloadTest reloadTest;

    @Scheduled(cron = "*/10 * * * * *")
    @PostConstruct
    void init(){
        System.out.println(propertyValue);
        System.out.println(reloadTest.getCompositeConfiguration().getString("test.reload"));
    }
}
