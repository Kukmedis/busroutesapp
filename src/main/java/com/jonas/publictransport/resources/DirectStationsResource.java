package com.jonas.publictransport.resources;

import com.jonas.publictransport.presentations.DirectRouteResponse;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Resource
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class DirectStationsResource {

    @GET
    @Path("/direct")
    @QueryParam("departure")
    public DirectRouteResponse isThereADirectRoute(@QueryParam("dep_sid") @NotNull Integer departure,
                                                   @QueryParam("arr_sid") @NotNull Integer arrival) {
        return new DirectRouteResponse(departure, arrival, true);
    }

}
