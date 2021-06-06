package io.cucumber.skeleton.StepsDefinition;

import io.cucumber.java.Status;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseClassStep implements ConcurrentEventListener {

    public static int value = 0;
    public static List<String> listOfString = new ArrayList<String>();
    public static String testDescription;

    public Integer getCountTest(){
        return value = value + 1;
    }

    public ArrayList addItem(String item1, Status item2){
        listOfString.add(item1 + " => " + item2);
        return (ArrayList) listOfString;
    }

    public String Step(){
        return testDescription;
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, setup);
        eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);

        eventPublisher.registerHandlerFor(TestStepStarted.class, new EventHandler<TestStepStarted>() {
            @Override
            public void receive(TestStepStarted event) {
                if (event.getTestStep() instanceof PickleStepTestStep) {
                    final PickleStepTestStep ev = (PickleStepTestStep) event.getTestStep();
                    final String args = StringUtils.join(Arrays.asList(ev.getDefinitionArgument().stream().map(Argument::getValue).toArray()), ",");
                    testDescription = ev.getStepText();
                }
            }
        });
    }

    private EventHandler<TestRunStarted> setup = event -> {
        beforeAll();
    };

    private void beforeAll() {
        System.out.println("in before all");
    }

    private EventHandler<TestRunFinished> teardown = event -> {
        afterAll();
    };

    private void afterAll() {
        System.out.println("in after all");
    }

}