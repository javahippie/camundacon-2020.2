package de.ilume.camunda.quarkus;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnglishPrinter implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(EnglishPrinter.class);

    public void execute(DelegateExecution execution) throws Exception {
        String number = (String) execution.getVariable("number");
        LOG.info(String.format("The number is %s", number));
    }

}
