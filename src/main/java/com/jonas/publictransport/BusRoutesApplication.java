package com.jonas.publictransport;

import com.jonas.publictransport.resources.DirectStationsResource;
import com.jonas.publictransport.routefinders.DirectRouteChecker;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class BusRoutesApplication extends Application<BusRoutesApplicationConfiguration> {

    @Override
    public void run(BusRoutesApplicationConfiguration configuration,
                    Environment environment) throws Exception {
        DirectRouteChecker directRouteChecker = new DirectRouteChecker(configuration.pathToData);
        DirectStationsResource directStationsResource = new DirectStationsResource(directRouteChecker);
        environment.jersey().register(directStationsResource);
    }

    public static void main(String[] args) throws Exception {
        new BusRoutesApplication().run(args);
    }
}
