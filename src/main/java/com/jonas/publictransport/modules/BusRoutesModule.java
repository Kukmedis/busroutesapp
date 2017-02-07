package com.jonas.publictransport.modules;

import com.google.inject.AbstractModule;

public class BusRoutesModule extends AbstractModule {

    private final String dataFilePath;

    public BusRoutesModule(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    protected void configure() {

    }


}
