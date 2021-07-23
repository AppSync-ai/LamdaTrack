package com.mt.lamdatrack.Rate.nodes;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.mt.lamdatrack.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NodeEraser {
    public static void Lamda(Context context) {

        InitilizingMethod as = new InitilizingMethod(context);
        as.getResponseFromUrl(new InitilizingMethod.ResponseListener() {
            @Override
            public void responser(String response, String datakey) {

                if (datakey.equalsIgnoreCase("Lamda")) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        if (jsonArray.length() > 0) {
                            JSONObject obj = jsonArray.getJSONObject(0);
                            int status = obj.getInt("status");
                            if (status == 1) {
                                new Rates.Rater().execute();
                            } else {
                                Rates.NCDEXrates kk = (Rates.NCDEXrates) context;
                                kk.FailedToLoad(context.getResources().getString(R.string.eeexpxpxpxrireed));
                            }
                        } else {
                            ((Activity) context).finishAffinity();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        as.getResponseFromUrlMethod(context.getResources().getString(R.string.yyyyyy) + context.getPackageName(), "Lamda");

    }
}
