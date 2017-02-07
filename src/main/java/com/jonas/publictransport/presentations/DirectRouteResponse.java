package com.jonas.publictransport.presentations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectRouteResponse {

    @JsonProperty("dep_sip")
    public final Integer depSid;

    @JsonProperty("arr_sip")
    public final Integer arrSid;

    @JsonProperty("direct_bus_route")
    public final Boolean directBusRoute;

    public DirectRouteResponse(Integer depSid, Integer arrSid, Boolean directBusRoute) {
        this.depSid = depSid;
        this.arrSid = arrSid;
        this.directBusRoute = directBusRoute;
    }
}
