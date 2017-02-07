package com.jonas.publictransport.core;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirectRoutesDataParserTest {

    @Test
    public void shouldParseFileToStationsDefinition() throws Exception {
        List<List<Integer>> stationDefinitions = DirectRoutesDataParser.parseStationsFromFile(
                (new File("src/test/resources/test_data.txt").getAbsolutePath()));
        assertEquals(Lists.newArrayList(
                Lists.newArrayList(0, 1, 2, 3, 4),
                Lists.newArrayList(3, 1, 6, 5),
                Lists.newArrayList(0, 6, 4)),
                stationDefinitions);
    }
}