package jide.delano.internationalsuperstarsoccerdeluxe.presenter;

import java.util.List;

import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;
import jide.delano.internationalsuperstarsoccerdeluxe.view.ViewContract;

public interface PresenterContract {
    void initRetrofit();
    void onBindView(ViewContract view);
    void unBind();
    void onMatchResultDataSuccess(List<MatchResult> match);
    void onMatchResultDataFailure(String errorMessage);

}