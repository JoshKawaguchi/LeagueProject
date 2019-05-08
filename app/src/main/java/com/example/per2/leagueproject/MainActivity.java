package com.example.per2.leagueproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button search;
    private Spinner region;
    private String regionArray[];
    private String reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regionArray = getResources().getStringArray(R.array.regions);
        wireWidgets();
        String reg = regionArray[region.getSelectedItemPosition()].toLowerCase();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(regionArray[region.getSelectedItemPosition()].toLowerCase(), "summoner",
                        "summoners", "by-name", "getAccountId");
            }
        });
    }

    public void search(String region, String what, String type, String how, String WhatToGet) {
        String url = "https://" + region + ".api.riotgames.com/lol/" + what + "/v4/" + type + "/" + how + "/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SummonerSearch service = retrofit.create(SummonerSearch.class);

        Call<Summoner> summonerResponseCall = service.searchByName(name.getText().toString());

        summonerResponseCall.enqueue(new Callback<Summoner>() {
            @Override
            public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                if (response.body() != null && !response.body().getAccountId().isEmpty()) {
                    String accId = response.body().getAccountId();

                    Toast.makeText(MainActivity.this, response.body().getAccountId(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "That name doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Summoner> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void searchMatchHistory(String region, String accId) {
        String url = "https://" + region + ".api.riotgames.com/lol/match/v4/matchlists/by-account/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchHistorySearch service = retrofit.create(MatchHistorySearch.class);

        Call<MatchHistory> matchHistoryResponseCall = service.searchById(accId);

        matchHistoryResponseCall.enqueue(new Callback<MatchHistory>() {
            @Override
            public void onResponse(Call<MatchHistory> call, Response<MatchHistory> response) {
                if (response.body() != null && response.body().getEndIndex() != 0) {

                }
            }

            @Override
            public void onFailure(Call<MatchHistory> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void searchIndMatch(String region, String gameId) {
        String url = "https://" + region + ".api.riotgames.com/lol/match/v4/matches/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchSearch service = retrofit.create(MatchSearch.class);

        Call<Match> matchHistoryResponseCall = service.searchByGame(gameId);

        matchHistoryResponseCall.enqueue(new Callback<Match>() {
            @Override
            public void onResponse(Call<Match> call, Response<Match> response) {
                if (response.body() != null && !response.body().getGameMode().isEmpty()) {
                    response.body().getParticipantIdentities().get(0).getPlayer();
                }
            }

            @Override
            public void onFailure(Call<Match> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void wireWidgets() {
        region = findViewById(R.id.spinner_MainActivity_region);
        name = findViewById(R.id.editText_MainActivity_Summoner);
        search = findViewById(R.id.button_MainActivity_Search);
    }
}
