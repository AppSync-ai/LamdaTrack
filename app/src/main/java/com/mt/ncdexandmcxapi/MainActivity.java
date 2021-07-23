package com.mt.ncdexandmcxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.nodes.Rates;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Rates.NCDEXrates {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rates.getAllRates(MainActivity.this);
    }

    @Override
    public void NcdexRates(ArrayList<RatesReq> list) {
        Log.wtf("Hulk-NCDEX : ", list.get(0).getTitle() + "");
    }

    @Override
    public void McxRates(ArrayList<RatesReq> list) {
        Log.wtf("Hulk-MCX : ", list.get(0).getTitle() + "");
    }

    @Override
    public void FailedToLoad(String error) {
        Toast.makeText(this, "Failed : " + error, Toast.LENGTH_SHORT).show();
    }
}