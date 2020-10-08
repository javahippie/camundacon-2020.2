/*
 * Copyright 2020 zoeller.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.javahippie.camundacon.springboot;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zoeller
 */
@RestController
@RequestMapping("/startProcess")
public class StartProcessController {
    
    private final ProcessEngine processEngine;
    
    public StartProcessController(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }
    
    @GetMapping
    public String start() {
        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("number", "5");
        inputVariables.put("language", "DE");

        return processEngine.getRuntimeService().startProcessInstanceByKey("Process_Native", inputVariables).getId();
    }
    
}
