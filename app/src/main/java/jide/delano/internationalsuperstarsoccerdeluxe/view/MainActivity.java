package jide.delano.internationalsuperstarsoccerdeluxe.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jide.delano.internationalsuperstarsoccerdeluxe.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import jide.delano.internationalsuperstarsoccerdeluxe.R;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;
import jide.delano.internationalsuperstarsoccerdeluxe.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements ViewContract {

    private RecyclerView recyclerView;
    private Presenter presenter;
    private LinearLayoutManager linearLayoutManager;
    private CustomAdapter customAdapter;
    private List<MatchResult> dataSet = new ArrayList<>();
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Intent intent = getIntent();
        presenter = new Presenter();

        initUI();
        onBindPresenter();
        initNetworkCall();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public void onBindPresenter() {
        presenter = new Presenter();
        presenter.onBindView(this);
    }

    @Override
    public void initNetworkCall() {
        presenter.initRetrofit();
    }

    @Override
    public void getMatchData(List<MatchResult> dataSet) {
        customAdapter.setDataSet(dataSet);
    }

    @Override
    public void initUI() {
        recyclerView = findViewById(R.id.video_recyclerview);
        customAdapter = new CustomAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void getFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT);

    }

}