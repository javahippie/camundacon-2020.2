/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ilume.camunda.quarkus;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;

/**
 *
 * @author zoeller
 */
@Singleton
public class EngineProvider {
    
    @Produces
    public ProcessEngine build() {
        ProcessEngine engine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE)
                .setJdbcUrl("jdbc:postgresql://localhost:5432/postgres")
                .setJdbcDriver("org.postgresql.Driver")
                .setJdbcUsername("postgres")
                .setJdbcPassword("scrapsafe")
                .setJdbcMaxActiveConnections(30)
                .setDatabaseSchemaUpdate("true")
                .setJobExecutorActivate(true)
                .buildProcessEngine();
        
        engine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("Native.bpmn")
                .deploy();
        
        return engine;
    }
    
}
