package com.jonas.publictransport.resources;

import com.jonas.publictransport.presentations.DirectRouteResponse;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Resource
@Path("/api")
public class DirectStationsResource {

    @GET
    @Path("/direct")
    @QueryParam("departure")
    public DirectRouteResponse isThereADirectRoute(@QueryParam("dep_sid") Integer departure,
                                                   @QueryParam("arr_sid") Integer arrival) {
        return new DirectRouteResponse(departure, arrival, true);
    }

}
