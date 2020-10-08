package de.javahippie.camundacon.springboot;

import org.camunda.bpm.engine.ProcessEngineConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.camunda.bpm.engine.ProcessEngine;

@Component
public class CamundaComponent {

    @Bean
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
