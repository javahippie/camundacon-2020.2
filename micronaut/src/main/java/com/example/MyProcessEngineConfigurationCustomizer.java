package com.example;

import info.novatec.micronaut.camunda.bpm.feature.DefaultProcessEngineConfigurationCustomizer;
import info.novatec.micronaut.camunda.bpm.feature.ProcessEngineConfigurationCustomizer;
import io.micronaut.context.annotation.Replaces;
import org.camunda.bpm.engine.ProcessEngineConfiguration;

import javax.inject.Singleton;

@Singleton
@Replaces(DefaultProcessEngineConfigurationCustomizer.class)
public class MyProcessEngineConfigurationCustomizer implements ProcessEngineConfigurationCustomizer {

    @Override
    public void customize(ProcessEngineConfiguration configuration) {
        // configure ProcessEngineConfiguration here, e.g.:
        configuration.setProcessEngineName("CustomizedEngine");
        configuration.setJdbcMaxActiveConnections(30);
        configuration.setJdbcMaxActiveConnections(30);
    }

}
