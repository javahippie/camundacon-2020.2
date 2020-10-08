package de.ilume.camunda.quarkus;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitPrinter implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(ExitPrinter.class);

    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Ending the Process");
    }

}
