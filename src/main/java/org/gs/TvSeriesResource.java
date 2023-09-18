package org.gs;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gs.model.Episode;
import org.gs.model.TvSerie;
import org.gs.model.proxy.EpisodeProxy;
import org.gs.model.proxy.TvSeriesProxy;

import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
public class TvSeriesResource {
    @RestClient
    TvSeriesProxy tvSeriesProxy;

    @RestClient
    EpisodeProxy episodeProxy;
    private List<TvSerie> tvSeries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title){
        TvSerie tvserie = tvSeriesProxy.get(title);
        List<Episode> episodes = episodeProxy.get(tvserie.getId());
        tvSeries.add(tvserie);
        return Response.ok(episodes).build();
    }

}
