package com.jonas.publictransport.routefinders;


import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirectRouteChecker {

    private List<List<Integer>> routeDatabase;

    public DirectRouteChecker(String pathToData) {
        List<String> fileContent;
        try {
            fileContent = Resources.readLines(Resources.getResource(pathToData), Charset.defaultCharset());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        fileContent.remove(0);
        routeDatabase = fileContent.stream().map(DirectRouteChecker::parseFileLine).collect(Collectors.toList());
    }

    public boolean isThereADirectRoute(Integer depSid, Integer arrSid) {
        return routeDatabase.stream().anyMatch(
                it -> it.contains(depSid) && it.contains(arrSid) && it.indexOf(depSid) < it.indexOf(arrSid));
    }

    private static List<Integer> parseFileLine(String line) {
        return Arrays.stream(line.replaceFirst("[^ ]+\\s", "").split(" "))
                .map(Integer::new).collect(Collectors.toList());
    }
}
