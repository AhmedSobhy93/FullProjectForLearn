package com.example.ahmed.calculator;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Nour on 5/22/2015.
 */
public class MyTask1 extends AsyncTask<String , String , String> {

    ProgressDialog myDialog;
    OnTaskCompleted onComplete ;

    public  MyTask1 (ProgressDialog progress , OnTaskCompleted onTask ){


        myDialog = progress ;
        this.onComplete = onTask ;

    }
    //method which working before background
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        myDialog.setMessage(" Now Loading ........ ");
        myDialog.setCancelable(false);
        myDialog.show();
        Log.d("Makany" , "PreExecute");


    }

    @Override
    protected String doInBackground(String... params) {


        try{

            HttpClient client = new DefaultHttpClient();
            HttpPost request = new HttpPost("http://x-doc.org/api1/Identity/authenticate");

            JSONObject json = new JSONObject();
            json.put("Email", params[0]);
            json.put("Password", params[1]);

            StringEntity se = new StringEntity(json.toString());
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            request.setEntity(se);

            String authorizationString = " Basic " + Base64.encodeToString(("tester" + ":" + "tm-sdktest").getBytes(), Base64.NO_WRAP);
            request.setHeader("Authorization" , authorizationString);

            HttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            JSONObject jsonObject = new JSONObject(result);
            String status = jsonObject.getString("Status");


            return status;


        } catch (Exception e)
        {
            e.printStackTrace();
        }


        Log.d("Makany" , "Do in Background");

        return null;
    }

    //method after background


    @Override
    protected void onPostExecute(String s) {

        myDialog.dismiss();
        onComplete.onTaskCompleted();
        Log.d("Makany" , "PostExecute");

        super.onPostExecute(s);



    }
}
