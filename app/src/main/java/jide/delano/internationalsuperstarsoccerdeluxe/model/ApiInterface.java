package jide.delano.internationalsuperstarsoccerdeluxe.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //https://www.scorebat.com/video-api/v1/
    @GET("video-api/v1/")//relative url
    Call<List<MatchResult>> getMatchResultsData();
}