package org.juhanir.message_server.rest.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import java.time.Instant;
import java.util.List;

public class TimeSeriesQueryParams {

    @QueryParam("from")
    @Parameter(description = "Start timestamp in ISO 8601 format")
    public Instant from;

    @QueryParam("to")
    @Parameter(description = "End timestamp in ISO 8601 format")
    public Instant to;

    @QueryParam("offset")
    @DefaultValue("0")
    @Parameter(description = "Pagination offset")
    public int offset;

    @QueryParam("limit")
    @DefaultValue("100")
    @Parameter(description = "Maximum number of results")
    public int limit;

    @QueryParam("sort")
    @DefaultValue("desc")
    @Parameter(description = "Sort order for time: asc|desc")
    public String sort;

    @QueryParam("device")
    @Parameter(description = "Device id. These can be chained.")
    public List<String> deviceIdentifiers;

    @QueryParam("signal")
    @Parameter(description = "Signal name. These can be chained.")
    public List<String> signals;

}
