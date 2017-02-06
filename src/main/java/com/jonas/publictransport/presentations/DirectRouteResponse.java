package com.jonas.publictransport.presentations;

public class DirectRouteResponse {

    public final Integer depSid;

    public final Integer arrSid;

    public final Boolean directBusRoute;

    public DirectRouteResponse(Integer depSid, Integer arrSid, Boolean directBusRoute) {
        this.depSid = depSid;
        this.arrSid = arrSid;
        this.directBusRoute = directBusRoute;
    }
}
