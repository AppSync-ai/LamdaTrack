package com.mt.ncdexandmcxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.nodes.McxRates;
import com.mt.lamdatrack.Rate.nodes.Rates;

import java.util.ArrayList;

import static android.util.Log.wtf;

public class MainActivity extends AppCompatActivity implements Rates.NCDEXrates, McxRates.MCXrates {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Rates.getAllRates(this);
    }

    @Override
    public void NcdexRates(ArrayList<RatesReq> list) {
        Log.wtf("Hulk-32", "" + list.size());
    }


    @Override
    public void McxRates(ArrayList<RatesReq> list) {
        Log.wtf("Hulk-39", "" + list.size());
    }

    @Override
    public void FailedToLoad(String error) {
        wtf("Hulk-err-44", error);
    }
}