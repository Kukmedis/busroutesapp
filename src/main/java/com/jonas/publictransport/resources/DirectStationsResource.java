package com.jonas.publictransport.resources;

import com.jonas.publictransport.representations.DirectRouteResponse;
import com.jonas.publictransport.core.DirectRouteChecker;

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

    private final DirectRouteChecker directRouteChecker;

    public DirectStationsResource(DirectRouteChecker directRouteChecker) {
        this.directRouteChecker = directRouteChecker;
    }

    @GET
    @Path("/direct")
    public DirectRouteResponse isThereADirectRoute(@QueryParam("dep_sid") @NotNull Integer depSid,
                                                   @QueryParam("arr_sid") @NotNull Integer arrSid) {
        return new DirectRouteResponse(depSid, arrSid, directRouteChecker.isThereADirectRoute(depSid, arrSid));
    }

}
