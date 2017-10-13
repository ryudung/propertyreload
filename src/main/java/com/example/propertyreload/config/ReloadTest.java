package com.example.propertyreload.config;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Develop In Action.
 * <p>
 * create by: ryugwanghyen
 * create Time : 2017-10-13
 */
@Component
public class ReloadTest {


    private ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder;

    @PostConstruct
    void init(){

         builder = new ReloadingFileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                .configure(new Parameters().fileBased().setFile(new File("src/main/resources/properties/common.properties")));

        PeriodicReloadingTrigger configReloadingTrigger = new PeriodicReloadingTrigger(
                builder.getReloadingController(), null, 1, TimeUnit.SECONDS);

        configReloadingTrigger.start();


    }

    public Configuration getCompositeConfiguration() {
        try {
            CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
            compositeConfiguration.addConfiguration(builder.getConfiguration());
            return compositeConfiguration;
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }


}
