package org.acme.events;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycleBean {
    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    public void onStart(@Observes StartupEvent event) {
        LOGGER.info("The application is starting... ");
    }

    public void onStop(@Observes ShutdownEvent event) {
        LOGGER.info("The application is stopping...");
    }
}
