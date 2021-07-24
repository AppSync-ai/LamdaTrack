package com.mt.lamdatrack.Rate.select;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.mt.lamdatrack.Rate.dmsssssssssssssssssssssssssssssssssssssssssssssss;
import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.internal.idjsidjsdsidniu3284re328r328r;
import com.mt.lamdatrack.Rate.nodes.Document;
import com.mt.lamdatrack.Rate.nodes.ksdskdmskdmskdmsdksmdksdmiewjriuerjiuerj8erje8rjei;

import java.io.IOException;
import java.util.ArrayList;

public class RatesParserWithoutContext {

    public static void GetAllRates(Context context) {

        new dksddddddddddsssssssssssssssssssssssssssssssssssssssssss99999999999999999999999kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk().execute(ksdskdmskdmskdmsdksmdksdmiewjriuerjiuerj8erje8rjei.pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii999999999999999999999999999 + context.getPackageName());

    }

    static class dsdskdskdmskdmskdsmdksmdkewjfiuwjfiwnmfiurewfj8934hfrj8934fgouirgfiuoergnfuios extends AsyncTask<String, String, String> {

        String kmsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd9iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii = "null";


        @Override
        protected String doInBackground(String... params) {

            final Document dsjikkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkeiwjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjurfffffffffffff99999999999999999999999999999999999999999999999;

            try {

                dsjikkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkeiwjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjurfffffffffffff99999999999999999999999999999999999999999999999 = dmsssssssssssssssssssssssssssssssssssssssssssssss.connect(idjsidjsdsidniu3284re328r328r.dsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdswewe2344e3dsdsdsdwe3e43e43dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa4233333333333333333333333333333333333333333333333333333333333333333333333333333333333)
                        .timeout(15000)
                        .get();

                aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa556.clear();
                pppppppppppppppppppppppppppppppppppppppppppp0000000000000000000000000000000000000000000000000000000000000000000000000000000.clear();

                nnnnndashjbhj(dsjikkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkeiwjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjurfffffffffffff99999999999999999999999999999999999999999999999);
                mmmmmsdkjfjkdfsjdsdsj(dsjikkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkeiwjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjurfffffffffffff99999999999999999999999999999999999999999999999);

                ncdexRates.postValue(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa556);
                mcxRates.postValue(pppppppppppppppppppppppppppppppppppppppppppp0000000000000000000000000000000000000000000000000000000000000000000000000000000);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        private void mmmmmsdkjfjkdfsjdsdsj(Document iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii9989) {
            Elements ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo77776 = iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii9989.getElementById("mcx").getElementsByClass("tableDataBox");
            int i = 0;
            try {
                do {
                    pppppppppppppppppppppppppppppppppppppppppppp0000000000000000000000000000000000000000000000000000000000000000000000000000000.add(new RatesReq("" + ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo77776.select("ol").select("li").select("a").get(i).text(),
                            "" + ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo77776.select("ol").select("li").select("strong").get(i).text(),
                            "" + ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo77776.select("ol").select("li").next().get(i).ownText(),
                            "" + ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo77776.select("ol").select("li").select("span").get(i).text()
                    ));
                    i++;
                }
                while (i != -1);
            } catch (Exception e) {
//                    Log.wtf("Hulk-57", e.getMessage());
                i = -1;

            }
        }


        private void nnnnndashjbhj(Document kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd121212) {
            Elements tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt43567 = kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd121212.getElementById("ncdex").getElementsByClass("tableDataBox");
            int i = 0;
            try {
                do {
                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa556.add(new RatesReq("" + tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt43567.select("ol").select("li").select("a").get(i).text(),
                            "" + tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt43567.select("ol").select("li").select("strong").get(i).text(),
                            "" + tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt43567.select("ol").select("li").next().get(i).ownText(),
                            "" + tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt43567.select("ol").select("li").select("span").get(i).text()
                    ));
                    i++;
                }
                while (i != -1);
            } catch (Exception e) {
                i = -1;

            }
        }

        @SuppressLint("RestrictedApi")
        @Override
        protected void onPostExecute(String iiuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu88u8uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu) {
            super.onPostExecute(iiuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu88u8uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu);


        }
    }

    public static MutableLiveData<ArrayList<RatesReq>> ncdexRates = new MutableLiveData<ArrayList<RatesReq>>();
    public static MutableLiveData<ArrayList<RatesReq>> mcxRates = new MutableLiveData<ArrayList<RatesReq>>();
    static ArrayList<RatesReq> aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa556 = new ArrayList<>();
    static ArrayList<RatesReq> pppppppppppppppppppppppppppppppppppppppppppp0000000000000000000000000000000000000000000000000000000000000000000000000000000 = new ArrayList<>();


}


