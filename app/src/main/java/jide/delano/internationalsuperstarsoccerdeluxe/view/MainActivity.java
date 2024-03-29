package jide.delano.internationalsuperstarsoccerdeluxe.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import jide.delano.internationalsuperstarsoccerdeluxe.R;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import java.util.List;
import jide.delano.internationalsuperstarsoccerdeluxe.model.MatchResult;
import jide.delano.internationalsuperstarsoccerdeluxe.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements ViewContract{

    private RecyclerView recyclerView;
    private Presenter presenter;
    private CustomAdapter customAdapter;
    private DrawerLayout drawer;
    private MatchResult matchResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_bundesliga:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BundesligaFragment()).commit();
                        break;
                    case R.id.ic_igue_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Ligue1Fragment()).commit();
                        break;
                    case R.id.ic_la_liga:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LaLigaFragment()).commit();
                        break;
                    case R.id.ic_major_league_soccer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MlsFragment()).commit();
                        break;
                    case R.id.ic_Primier_league:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PremierFragment()).commit();
                        break;
                    case R.id.ic_seria_a:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SeriaAFragment()).commit();
                        break;
                }
                return true;
            }
        });

        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
        customAdapter = new CustomAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void getFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT);

    }
}