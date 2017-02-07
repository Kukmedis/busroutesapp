package com.jonas.publictransport.routefinders;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectRouteCheckerTest {

    private DirectRouteChecker directRouteChecker = new DirectRouteChecker("test_data.txt");

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