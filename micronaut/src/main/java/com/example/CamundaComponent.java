package com.example;

import java.util.HashMap;
import java.util.Map;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Singleton;

@Singleton
public class CamundaComponent {

    private final ProcessEngine processEngine;
    private final RuntimeService runtimeService;

    public CamundaComponent(ProcessEngine processEngine, RuntimeService runtimeService) {
        this.processEngine = processEngine;
        this.runtimeService = runtimeService;
    }

}
