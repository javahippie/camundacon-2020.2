package de.javahippie.camunda.nativeimage;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {

        LOG.info("Starting the application");

        ProcessEngine processEngine = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration()
                .setJdbcDriver("org.postgresql.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .setJdbcUrl("jdbc:postgresql://localhost:5432/postgres")
                .setJdbcUsername("postgres")
                .setJdbcPassword("cal_pw")
                .setJobExecutorActivate(true)
                .buildProcessEngine();

        LOG.info("Created the Process Engine");

        processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("Native.bpmn").deploy();

        LOG.info("Deployed Native.bpmm");

        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("number", "5");
        inputVariables.put("language", "DE");

        processEngine
                .getRuntimeService()
                .startProcessInstanceByKey("Process_Native", inputVariables);

        LOG.info("Process was started");
    }
}
