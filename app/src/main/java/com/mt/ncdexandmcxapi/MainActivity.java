package com.mt.ncdexandmcxapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.select.RatesParserWithoutContext;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatesParserWithoutContext.GetAllRates(getApplicationContext());

        RatesParserWithoutContext.ncdexRates.observeForever(new Observer<ArrayList<RatesReq>>() {
            @Override
            public void onChanged(ArrayList<RatesReq> ratesReqs) {
                Log.wtf("Hulk-30", ratesReqs.get(9).getTitle() + " : " + ratesReqs.get(9).getRate() + "");
            }
        });

        RatesParserWithoutContext.mcxRates.observeForever(new Observer<ArrayList<RatesReq>>() {
            @Override
            public void onChanged(ArrayList<RatesReq> ratesReqs) {
                Log.wtf("Hulk-36", ratesReqs.size() + "");
            }
        });


    }


}