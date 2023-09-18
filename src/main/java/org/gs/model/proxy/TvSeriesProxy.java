package org.gs.model.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.gs.model.TvSerie;


@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
        //(baseUri = "https://api.tvmaze.com/") configurado en application.properties
public interface TvSeriesProxy {
    @GET
    @Path("/shows")
    TvSerie get(@QueryParam("q") String title);
    }

