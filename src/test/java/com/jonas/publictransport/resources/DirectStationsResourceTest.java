package com.jonas.publictransport.resources;

import com.jonas.publictransport.routefinders.DirectRouteChecker;
import io.dropwizard.testing.FixtureHelpers;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.BadRequestException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectStationsResourceTest {

    private static final DirectRouteChecker directRouteChecker = mock(DirectRouteChecker.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new DirectStationsResource(directRouteChecker))
            .build();

    @Test
    public void shouldTellWhenThereIsADirectRoute() throws Exception {
        when(directRouteChecker.isThereADirectRoute(1, 2)).thenReturn(true);

        String response = resources.client().target("/api/direct?dep_sid=1&arr_sid=2").request().get(String.class);

        assertEquals(FixtureHelpers.fixture("responses/direct_true.json"), response);
    }

    @Test
    public void shouldTellWhenThereIsNoDirectRoute() throws Exception {
        String response = resources.client().target("/api/direct?dep_sid=3&arr_sid=4").request().get(String.class);

        assertEquals(FixtureHelpers.fixture("responses/direct_false.json"), response);
    }

    @Test(expected=BadRequestException.class)
    public void stationsShouldBeMandatory() throws Exception {
        resources.client().target("/api/direct").request().get(String.class);
    }
}