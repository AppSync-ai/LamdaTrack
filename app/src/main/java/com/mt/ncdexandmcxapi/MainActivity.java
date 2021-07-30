package com.mt.ncdexandmcxapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.nodes.Rates;
import com.mt.lamdatrack.Rate.safety.NcdexCom;
import com.mt.lamdatrack.Rate.select.RatesParserWithoutContext;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Rates.NCDEXrates {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Rates.getAllRates(this);
        RatesParserWithoutContext.GetAllRates(getApplicationContext());

        RatesParserWithoutContext.ncdexRates.observeForever(new Observer<ArrayList<RatesReq>>() {
            @Override
            public void onChanged(ArrayList<RatesReq> ratesReqs) {
                Log.wtf("Hulk-37", ratesReqs.size() + "");
            }
        });

    }


    @Override
    public void NcdexRates(ArrayList<RatesReq> list) {
        Log.wtf("Hulk-34-ncdex", list.get(0).getTitle());
    }

    @Override
    public void McxRates(ArrayList<RatesReq> list) {

    }

    @Override
    public void FailedToLoad(String error) {
        Log.wtf("Hulk-err-44", error);
    }
}