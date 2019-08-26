package jide.delano.internationalsuperstarsoccerdeluxe.view;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import jide.delano.internationalsuperstarsoccerdeluxe.R;

public class WebActivity extends AppCompatActivity {

    private WebView webWebView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webWebView = findViewById(R.id.wv_webview);

        Intent intent = getIntent();
        url = intent.getExtras().getString("Url");

        webWebView = (WebView) findViewById(R.id.detail_webview);;
        webWebView.getSettings().setJavaScriptEnabled(true);
        webWebView.setWebViewClient(new WebViewClient());
        webWebView.loadUrl(url);
    }
}

