package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by sasiporn on 2/8/2018 AD.
 */

public class GetAllValueFromServer extends AsyncTask<String, Void, String>{

    private Context context;

    public GetAllValueFromServer(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();



        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


    }
}
