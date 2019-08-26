package jide.delano.internationalsuperstarsoccerdeluxe.view;

import java.util.List;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;

public interface ViewContract  {
    void onBindPresenter();
    void initNetworkCall();
    void getMatchData(List<MatchResult> dataSet);
    void initUI();
    void getFailureMessage(String message);

}