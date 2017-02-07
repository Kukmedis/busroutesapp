package com.jonas.publictransport;

import com.jonas.publictransport.resources.DirectStationsResource;
import com.jonas.publictransport.routefinders.DirectRouteChecker;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class BusRoutesApplication extends Application<BusRoutesApplicationConfiguration> {

    public void run(BusRoutesApplicationConfiguration busRoutesApplicationConfiguration,
                    Environment environment) throws Exception {
        DirectRouteChecker directRouteChecker =
                new DirectRouteChecker(busRoutesApplicationConfiguration.pathToData);
        environment.jersey().register(DirectStationsResource.class);
    }
}
