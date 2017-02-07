package com.jonas.publictransport;

import io.dropwizard.Configuration;

public class BusRoutesApplicationConfiguration extends Configuration {

    public final String pathToData;

    public BusRoutesApplicationConfiguration(String pathToData) {
        this.pathToData = pathToData;
    }
}
