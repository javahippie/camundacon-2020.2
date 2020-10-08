package de.ilume.camunda.quarkus;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/startProcess")
public class RestEndpoint {

    @Inject
    ProcessEngine engine;

    @GET
    public Response startProcessInstance(@QueryParam("processId") String processId) {
        ProcessInstance instance = engine.getRuntimeService().startProcessInstanceByKey(processId);
        return Response.ok(instance.getProcessInstanceId()).build();
    }

}
