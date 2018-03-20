package com.adeep.carousel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Game> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FeatureCoverFlow coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        CoverFlowAdapter adapter = new CoverFlowAdapter(this, games);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        games = new ArrayList<>();
        games.add(new Game(R.mipmap.a, "Reverse Coding"));
        games.add(new Game(R.mipmap.ic_launcher, "Code2Create"));
        games.add(new Game(R.mipmap.ic_launcher_round, "Codart"));

    }
}