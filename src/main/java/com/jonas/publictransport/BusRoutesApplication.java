package com.jonas.publictransport;

import com.codahale.metrics.health.jvm.ThreadDeadlockHealthCheck;
import com.jonas.publictransport.resources.DirectStationsResource;
import com.jonas.publictransport.core.DirectRouteChecker;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BusRoutesApplication extends Application<BusRoutesApplicationConfiguration> {

    @Override
    public void run(BusRoutesApplicationConfiguration configuration,
                    Environment environment) throws Exception {
        DirectRouteChecker directRouteChecker = new DirectRouteChecker(
                Files.readAllLines(Paths.get(configuration.getPathToData())));
        DirectStationsResource directStationsResource = new DirectStationsResource(directRouteChecker);
        environment.jersey().register(directStationsResource);
        environment.healthChecks().register("ping", new ThreadDeadlockHealthCheck());
    }

    @Override
    public void initialize(Bootstrap<BusRoutesApplicationConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
    }

    public static void main(String[] args) throws Exception {
        new BusRoutesApplication().run(args);
    }
}
