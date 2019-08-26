package jide.delano.internationalsuperstarsoccerdeluxe.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import jide.delano.internationalsuperstarsoccerdeluxe.R;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;

public class VideoActivity extends AppCompatActivity {

    private MatchResult matchResult;
    private String embed;
    private String time;
    private TextView videoUrlTextView;
    private TextView side1TextView;
    private TextView side2TextView;
    private TextView detailCompetitionNameTextView;
    private WebView vide0WebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        matchResult = intent.getParcelableExtra("jsonRes");

        embed = matchResult.getEmbed();

        vide0WebView =  findViewById(R.id.detail_webview);
        vide0WebView.setWebChromeClient(new WebChromeClient());
        vide0WebView.setWebViewClient(new WebViewClient());
        vide0WebView.getSettings().setJavaScriptEnabled(true);
        vide0WebView.loadData(embed, "text/html", null);

        videoUrlTextView = findViewById(R.id.video_url_textview);
        side1TextView = findViewById(R.id.side1_name_textview);
        side2TextView = findViewById(R.id.side2_name_textview);
        detailCompetitionNameTextView = findViewById(R.id.detail_competition_name_textview);

        videoUrlTextView.setText("Click to go to Video Page");
        side1TextView.setText(matchResult.getSide1().getName() + "   go to team page");
        side2TextView.setText(matchResult.getSide2().getName() + "   go to team page");
        detailCompetitionNameTextView.setText(matchResult.getCompetition().getName()  + "   go to competition page");

        videoUrlTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(matchResult.getUrl());
                Log.d("V1url", matchResult.getUrl());
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.putExtra("Url", matchResult.getUrl());
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        side1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(matchResult.getSide1().getUrl());
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.putExtra("Url", matchResult.getSide1().getUrl());
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        side2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(matchResult.getSide2().getUrl());
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.putExtra("Url", matchResult.getSide2().getUrl());
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        detailCompetitionNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(matchResult.getCompetition().getUrl());
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.putExtra("Url", matchResult.getCompetition().getUrl());
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
