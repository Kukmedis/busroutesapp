package com.jonas.publictransport.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirectRoutesDataParser {

    private DirectRoutesDataParser() {
    }

    public static List<List<Integer>> parseStationsFromFile(String pathToData) {
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(Paths.get(pathToData));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        List<String> routesData = fileLines.subList(1, fileLines.size()); //remove routes count
        return routesData.stream().map(DirectRoutesDataParser::parseDataLine).collect(Collectors.toList());
    }

    private static List<Integer> parseDataLine(String line) {
        return Arrays.stream(line.replaceFirst("[^ ]+\\s", "").split(" ")) //remove unnecessary station id
                .map(Integer::new).collect(Collectors.toList());
    }

}
