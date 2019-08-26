package jide.delano.internationalsuperstarsoccerdeluxe.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import jide.delano.internationalsuperstarsoccerdeluxe.R;

public class PremierFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.premier_league, container, false );
        WebView webView = v.findViewById(R.id.wv_premier);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.scorebat.com/england-premier-league-live-scores/");
        webView.setWebViewClient(new WebViewClient());
        return v;
    }
}
