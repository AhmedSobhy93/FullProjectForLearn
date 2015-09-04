package com.example.ahmed.calculator;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ProgressBar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by Ahmed on 5/22/2015.
 */
public class MyTask extends AsyncTask<String, String, String> {

    ProgressDialog ps1;
    OnTaskCompleted onComplete ;

    public MyTask(ProgressDialog ps,OnTaskCompleted otc) {
        this.ps1 = ps;
        this.onComplete=otc;
    }

    @Override
    protected void onPreExecute() {
        Log.d("Makanay", "Pre-Execute");
        ps1.setMessage("Now Loading...");
        ps1.setCancelable(false);
        ps1.show();

        super.onPreExecute();
    }

    @Override
    //... means Infinity Overloading
    protected String doInBackground(String... params) {
        try {
            HttpClient client=new DefaultHttpClient();
            HttpPost request=new HttpPost("http://x-doc.org/apil/Identity/authentication");

            JSONObject json=new JSONObject();
            json.put("Email" , params[0]);
            json.put("Password",params[1]);

            StringEntity se=new StringEntity(json.toString());
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


        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("Makanay", "Do in BackGround");

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("Makanay", "Post-Execute");
        ps1.dismiss();
        onComplete.onTaskCompleted();
        super.onPostExecute(s);
    }
}
