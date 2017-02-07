package com.jonas.publictransport.core;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectRouteCheckerTest {

    private DirectRouteChecker directRouteChecker;

    @Before
    public void setUp() throws Exception {
        directRouteChecker = new DirectRouteChecker(Files.readAllLines(
                Paths.get(new File("src/test/resources/test_data.txt").getAbsolutePath())));
    }

    @Test
    public void shouldTellThenThereIsADirectRoute() throws Exception {
        assertTrue(directRouteChecker.isThereADirectRoute(6, 4));
    }

    @Test
    public void shouldTellThenThereIsNoDirectRoute() throws Exception {
        assertFalse(directRouteChecker.isThereADirectRoute(2, 6));
    }

    @Test
    public void shouldMindTheDirectionOfRoute() throws Exception {
        assertFalse(directRouteChecker.isThereADirectRoute(4, 6));
    }

    @Test
    public void shouldNotFindARouteBetweenNonExistentStations() throws Exception {
        assertFalse(directRouteChecker.isThereADirectRoute(10, 11));
    }

    @Test
    public void shouldNotFindARouteBetweenSameStation() throws Exception {
        assertFalse(directRouteChecker.isThereADirectRoute(2, 2));
    }
}