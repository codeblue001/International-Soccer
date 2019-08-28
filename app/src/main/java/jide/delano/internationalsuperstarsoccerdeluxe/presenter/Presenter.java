package jide.delano.internationalsuperstarsoccerdeluxe.presenter;


import java.util.List;
import jide.delano.internationalsuperstarsoccerdeluxe.model.ApiInterface;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;
import jide.delano.internationalsuperstarsoccerdeluxe.view.ViewContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    private ViewContract view;

    @Override
    public void onBindView(ViewContract view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        view = null;
    }

    @Override
    public void initRetrofit() {
        //Create instance of retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.scorebat.com/")//base url
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Create instance of API interface
      retrofit.create(ApiInterface.class)
              .getMatchResultsData()
        //use enqueue instead of execute so that it runs asynchronously
        .enqueue(new Callback<List<MatchResult>>() {
            @Override
            public void onResponse(Call<List<MatchResult>> call, Response<List<MatchResult>> response) {
                onMatchResultDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<MatchResult>> call, Throwable t) {
                onMatchResultDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void onMatchResultDataSuccess(List<MatchResult> match) {
        view.getMatchData(match);
    }

    @Override
    public void onMatchResultDataFailure(String errorMessage) {
        view.getFailureMessage(errorMessage);
    }
}