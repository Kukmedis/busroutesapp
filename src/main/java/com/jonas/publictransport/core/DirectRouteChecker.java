package com.jonas.publictransport.core;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirectRouteChecker {

    private List<List<Integer>> routeDatabase;

    public DirectRouteChecker(List<String> dataContents) {
        dataContents.remove(0);
        routeDatabase = dataContents.stream().map(DirectRouteChecker::parseDataLine).collect(Collectors.toList());
    }

    public boolean isThereADirectRoute(Integer depSid, Integer arrSid) {
        return routeDatabase.stream().anyMatch(
                it -> it.contains(depSid) && it.contains(arrSid) && it.indexOf(depSid) < it.indexOf(arrSid));
    }

    private static List<Integer> parseDataLine(String line) {
        return Arrays.stream(line.replaceFirst("[^ ]+\\s", "").split(" "))
                .map(Integer::new).collect(Collectors.toList());
    }
}
