package com.jonas.publictransport.core;


import java.util.List;

public class DirectRouteChecker {

    private List<List<Integer>> routeDatabase;

    public DirectRouteChecker(List<List<Integer>> routeDefinitions) {
        routeDatabase = routeDefinitions;
    }

    public boolean isThereADirectRoute(Integer depSid, Integer arrSid) {
        return routeDatabase.stream().anyMatch(
                it -> it.contains(depSid) && it.contains(arrSid) && it.indexOf(depSid) < it.indexOf(arrSid));
    }
}
