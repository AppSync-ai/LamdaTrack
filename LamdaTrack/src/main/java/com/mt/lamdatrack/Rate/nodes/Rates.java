package com.mt.lamdatrack.Rate.nodes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import com.mt.lamdatrack.R;
import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.select.Elements;

import java.util.ArrayList;

public class Rates {

    public static void getAllRates(Context context) {

        KKLKLKLKLKLKLKLKLKLAD = context;
        KPKKKKLKLKLAAAADWEDWED.KOKPOKOKLKL(KKLKLKLKLKLKLKLKLKLAD);

    }

    static class OPOOPOPOOJHFGVGCDX extends AsyncTask<String, String, String> {

//    load states all with their links href

        @Override
        protected String doInBackground(String... params) {
            Document JNOSDAJNSADJNSDAJNKSDA = null;
            try {
                KKjbjj.jkndosajskdno(KJLSDAKLSDKJLKDJLSKDJASNKDJKJN, KOJKOJKOJKJOKLJKLJKLJ);

                JNOSDAJNSADJNSDAJNKSDA = UHUnbnnbsd.sdfdssd(JNOSDAJNSADJNSDAJNKSDA, KKLKLKLKLKLKLKLKLKLAD);

                nnnnndashjbhj(JNOSDAJNSADJNSDAJNKSDA);
                mmmmmsdkjfjkdfsjdsdsj(JNOSDAJNSADJNSDAJNKSDA);


                try {
                    NCDEXrates nn = (NCDEXrates) KKLKLKLKLKLKLKLKLKLAD;
                    nn.NcdexRates(KJLSDAKLSDKJLKDJLSKDJASNKDJKJN);
                    nn.McxRates(KOJKOJKOJKJOKLJKLJKLJ);
                } catch (Exception v) {
                    Log.wtf("Hulk-65", v.getMessage());
                }


            } catch (Exception v) {
                NCDEXrates ff = (NCDEXrates) KKLKLKLKLKLKLKLKLKLAD;
                ff.FailedToLoad(v.getMessage());

            }

            return null;
        }

        private void nnnnndashjbhj(Document kkkkkskdsdsdsdewdefejnvnvnvnvnvbgb) {
            Elements uiojjouijiosfjosfjosjfksjfiosfjskofjsofjsjfhyuirehgyfrnui = kkkkkskdsdsdsdewdefejnvnvnvnvnvbgb.getElementById(KKLKLKLKLKLKLKLKLKLAD.getResources().getString(R.string.jknljnjnk)).getElementsByClass("tableDataBox");
            int i = 0;
            try {
                do {
                    KJLSDAKLSDKJLKDJLSKDJASNKDJKJN.add(new RatesReq("" + uiojjouijiosfjosfjosjfksjfiosfjskofjsofjsjfhyuirehgyfrnui.select("ol").select("li").select("a").get(i).text(),
                            "" + uiojjouijiosfjosfjosjfksjfiosfjskofjsofjsjfhyuirehgyfrnui.select("ol").select("li").select("strong").get(i).text(),
                            "" + uiojjouijiosfjosfjosjfksjfiosfjskofjsofjsjfhyuirehgyfrnui.select("ol").select("li").next().get(i).ownText(),
                            "" + uiojjouijiosfjosfjosjfksjfiosfjskofjsofjsjfhyuirehgyfrnui.select("ol").select("li").select("span").get(i).text()
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
            Elements UUUUUUUUDCHUSBCHJSBFBWFHBFHEBFHJBHBVFEHJVBFEHJGBGBHGRBG = pageDocument.getElementById(KKLKLKLKLKLKLKLKLKLAD.getResources().getString(R.string.mmmadjja)).getElementsByClass(KKLKLKLKLKLKLKLKLKLAD.getResources().getString(R.string.HJBHJBHJBJHBHJBHJBHJS));
            int i = 0;
            try {
                do {
                    KOJKOJKOJKJOKLJKLJKLJ.add(new RatesReq("" + UUUUUUUUDCHUSBCHJSBFBWFHBFHEBFHJBHBVFEHJVBFEHJGBGBHGRBG.select("ol").select("li").select("a").get(i).text(),
                            "" + UUUUUUUUDCHUSBCHJSBFBWFHBFHEBFHJBHBVFEHJVBFEHJGBGBHGRBG.select("ol").select("li").select("strong").get(i).text(),
                            "" + UUUUUUUUDCHUSBCHJSBFBWFHBFHEBFHJBHBVFEHJVBFEHJGBGBHGRBG.select("ol").select("li").next().get(i).ownText(),
                            "" + UUUUUUUUDCHUSBCHJSBFBWFHBFHEBFHJBHBVFEHJVBFEHJGBGBHGRBG.select("ol").select("li").select("span").get(i).text()
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
            ((Activity) KKLKLKLKLKLKLKLKLKLAD).runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });


        }

    }

    static Context KKLKLKLKLKLKLKLKLKLAD = null;
    static ArrayList<RatesReq> KJLSDAKLSDKJLKDJLSKDJASNKDJKJN = new ArrayList<>();
    static ArrayList<RatesReq> KOJKOJKOJKJOKLJKLJKLJ = new ArrayList<>();

    public interface NCDEXrates {
        public void NcdexRates(ArrayList<RatesReq> list);

        public void McxRates(ArrayList<RatesReq> list);

        public void FailedToLoad(String error);
    }
}
