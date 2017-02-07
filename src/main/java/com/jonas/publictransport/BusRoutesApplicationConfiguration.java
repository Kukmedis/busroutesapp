package com.jonas.publictransport;

import io.dropwizard.Configuration;

public class BusRoutesApplicationConfiguration extends Configuration {

    private String pathToData;

    public String getPathToData() {
        return pathToData;
    }

    public void setPathToData(String pathToData) {
        this.pathToData = pathToData;
    }
}
