package com.example.per2.leagueproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regionArray = getResources().getStringArray(R.array.regions);
        wireWidgets();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchSummoner();
            }
        });
    }

    private void searchSummoner() {
        String text = regionArray[region.getSelectedItemPosition()].toLowerCase();
        String url = "https://"+text+".api.riotgames.com/lol/summoner/v4/summoners/by-name/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SummonerSearch service = retrofit.create(SummonerSearch.class);

        Call<Summoner> summonerResponseCall = service.searchByName(name.getText().toString());

        summonerResponseCall.enqueue(new Callback<Summoner>() {
            @Override
            public void onResponse(Call<Summoner> call, Response<Summoner> response) {

                if (response.body() != null && !response.body().getId().isEmpty()) {
//                    String lyrics = response.body().getLyrics().toString();
//                    Intent Lyrics = new Intent(MainActivity.this,
//                            displayLyrics.class);
//
//                    Lyrics.putExtra(LYRICS, lyrics);
//                    startActivity(Lyrics);
                    Toast.makeText(MainActivity.this, "work", Toast.LENGTH_SHORT).show();
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

    private void wireWidgets() {
        region = findViewById(R.id.spinner_MainActivity_region);
        name = findViewById(R.id.editText_MainActivity_Summoner);
        search = findViewById(R.id.button_MainActivity_Search);
    }
}
