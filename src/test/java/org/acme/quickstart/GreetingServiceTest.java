package org.acme.quickstart;

import javax.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import org.jboss.qa.eap.panda.Main;
import org.jboss.qa.eap.panda.configuration.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingServiceTest {

    @Inject
    GreetingService service;

    @Test
    public void testGreetingService() {
        Assertions.assertEquals("Good morning Quarkus", service.greeting("Quarkus"));
    }

    @Test
    public void pandak() {
        Main panda = new Main();
        Configuration configuration = panda.getConfiguration();
        // load panda.properties
        configuration.loadConfigurationValuesFromPropertyFiles();

        // set options
        configuration.setServerURL("https://polarion.engineering.redhat.com/");
        configuration.setUserName("mstary");
        configuration.setPassword("298123Crossingaline");
        configuration.setTestResultsFolder("/home/mstary/Workspace/quarkus-quickstarts/getting-started/target/surefire-reports");
        configuration.setKeystoreFile("/home/mstary/Workspace/panda/polarion.jks");
        //configuration.setKeystoreFile("/home/mstary/Downloads/polarion.jks");
        configuration.setProjectId("QUARKUS");
        configuration.setTestSuiteId("QUARKUS-76");
        configuration.setAssignee("quarkus_machine");
        configuration.setUpstream("Yes");
        configuration.setComponent("comp1");
        configuration.setImportance("medium");
        configuration.setProcessWithEmptyTs(true);
        configuration.setInputFormat("JUnit");
        configuration.setPostProcessing("LinkToTestSource");
        configuration.setPolisher("DeleteTestCasesNameNull");
        configuration.setPlannedIn("Quarkus-random-plan");

        // set operation
        configuration.setOperation("test-run-upload");

        System.out.println();
        System.out.println("Vypis: " + configuration.getTestCaseAutomation());
        System.out.println();

        panda.runPanda();
    }
}
