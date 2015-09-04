package com.example.ahmed.calculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class CameraPage extends ActionBarActivity implements View.OnClickListener{

    Button takePicBtn;
    ImageView showImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        takePicBtn=(Button)findViewById(R.id.Camera_TakePic_Button);
        takePicBtn.setOnClickListener(this);

        showImgView=(ImageView)findViewById(R.id.Camera_ShowImage_ImageView);


    }


    @Override
    public void onClick(View v) {
        if(v==takePicBtn)
        {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Bitmap image=(Bitmap)data.getExtras().get("data");
            showImgView.setImageBitmap(image);
        }
    }
}
