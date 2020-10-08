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
package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.HashMap;
import java.util.Map;
import org.camunda.bpm.engine.RuntimeService;

/**
 *
 * @author zoeller
 */
@Controller("/startProcess")
public class StartProcessController {
    
    private final RuntimeService runtimeService;
    
    public StartProcessController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }
    
    @Get
    public String start() {
        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("number", "5");
        inputVariables.put("language", "DE");

        return runtimeService.startProcessInstanceByKey("Process_Native", inputVariables).getId();
    }
    
}
