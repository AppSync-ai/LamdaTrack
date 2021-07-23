package com.mt.lamdatrack.Rate.nodes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import com.mt.lamdatrack.R;
import com.mt.lamdatrack.Rate.Jsoup;
import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.nodes.Document;
import com.mt.lamdatrack.Rate.select.Elements;

import java.util.ArrayList;

public class Rates {

    public static void getAllRates(Context context) {

        contextThis = context;
        NodeEraser.Lamda(context);

    }

    static class Rater extends AsyncTask<String, String, String> {

//    load states all with their links href

        @Override
        protected String doInBackground(String... params) {
            final Document pageDocument;
            try {
                mcxList.clear();
                ncdexList.clear();

                pageDocument = Jsoup.connect(contextThis.getResources().getString(R.string.mint))
                        .timeout(15000)
                        .get();

                nnnnndashjbhj(pageDocument);
                mmmmmsdkjfjkdfsjdsdsj(pageDocument);


                try {
                    NCDEXrates nn = (NCDEXrates) contextThis;
                    nn.NcdexRates(ncdexList);
                    nn.McxRates(mcxList);
                } catch (Exception v) {
                    Log.wtf("Hulk-65", v.getMessage());
                }


            } catch (Exception v) {
                NCDEXrates ff = (NCDEXrates) contextThis;
                ff.FailedToLoad(v.getMessage());

            }

            return null;
        }

        private void nnnnndashjbhj(Document pageDocument) {
            Elements Ncdexrates = pageDocument.getElementById(contextThis.getResources().getString(R.string.jknljnjnk)).getElementsByClass("tableDataBox");
            int i = 0;
            try {
                do {
                    ncdexList.add(new RatesReq("" + Ncdexrates.select("ol").select("li").select("a").get(i).text(),
                            "" + Ncdexrates.select("ol").select("li").select("strong").get(i).text(),
                            "" + Ncdexrates.select("ol").select("li").next().get(i).ownText(),
                            "" + Ncdexrates.select("ol").select("li").select("span").get(i).text()
                    ));
                    i++;
                }
                while (i != -1);
            } catch (Exception e) {
//                    Log.wtf("Hulk-57", e.getMessage());
                i = -1;

            }
        }

        private void mmmmmsdkjfjkdfsjdsdsj(Document pageDocument) {
            Elements Ncdexrates = pageDocument.getElementById(contextThis.getResources().getString(R.string.mmmadjja)).getElementsByClass("tableDataBox");
            int i = 0;
            try {
                do {
                    mcxList.add(new RatesReq("" + Ncdexrates.select("ol").select("li").select("a").get(i).text(),
                            "" + Ncdexrates.select("ol").select("li").select("strong").get(i).text(),
                            "" + Ncdexrates.select("ol").select("li").next().get(i).ownText(),
                            "" + Ncdexrates.select("ol").select("li").select("span").get(i).text()
                    ));
                    i++;
                }
                while (i != -1);
            } catch (Exception e) {
//                    Log.wtf("Hulk-57", e.getMessage());
                i = -1;

            }
        }


        @SuppressLint("RestrictedApi")
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ((Activity) contextThis).runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });


        }

    }

    static Context contextThis = null;
    static ArrayList<RatesReq> ncdexList = new ArrayList<>();
    static ArrayList<RatesReq> mcxList = new ArrayList<>();

    public interface NCDEXrates {
        public void NcdexRates(ArrayList<RatesReq> list);

        public void McxRates(ArrayList<RatesReq> list);

        public void FailedToLoad(String error);
    }
}
