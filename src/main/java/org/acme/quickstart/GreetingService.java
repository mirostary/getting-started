package org.acme.quickstart;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name = "greeting")
    private String greeting;

    public String greeting(String name) {
        return greeting + " " + name;
    }

    public CompletionStage<String> greetingAsync(String name) {
        return CompletableFuture.supplyAsync(() -> "hello " + name);
    }

}