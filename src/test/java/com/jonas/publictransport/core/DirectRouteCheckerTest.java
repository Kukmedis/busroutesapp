package com.jonas.publictransport.core;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectRouteCheckerTest {

    private DirectRouteChecker directRouteChecker;

    @Before
    public void setUp() throws Exception {
        directRouteChecker = new DirectRouteChecker(Lists.newArrayList(
                Lists.newArrayList(0, 1, 2, 3, 4),
                Lists.newArrayList(3, 1, 6, 5),
                Lists.newArrayList(0, 6, 4)));
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