package jide.delano.internationalsuperstarsoccerdeluxe.view;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import jide.delano.internationalsuperstarsoccerdeluxe.R;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;

public class VideoActivity extends AppCompatActivity {
    private MatchResult matchResult;
    private String embed;
    private String time;
    private WebView vide0WebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        matchResult = intent.getParcelableExtra("videoResponse");

        embed = matchResult.getEmbed();

        vide0WebView =  findViewById(R.id.detail_webview);
        vide0WebView.setWebChromeClient(new WebChromeClient());
        vide0WebView.setWebViewClient(new WebViewClient());
        vide0WebView.getSettings().setJavaScriptEnabled(true);
        vide0WebView.loadData(embed, "text/html", null);
    }
}
