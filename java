package com.example.aninterface;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_StartAndStop;
    private Chronometer chronometer;
    private TextView tv_accX;
    private TextView tv_accY;
    private TextView tv_accZ;
    private TextView tv_gyrX;
    private TextView tv_gyrY;
    private TextView tv_gyrZ;
    private TextView tv_heart;
    private Toast toast;



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkCallingPermission(Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BODY_SENSORS}, 100);
        }
        btn_StartAndStop = findViewById(R.id.btn_StartAndStop);
        chronometer = findViewById(R.id.chronometer);
        tv_accX = findViewById(R.id.tv_accX);
        tv_accY = findViewById(R.id.tv_accY);
        tv_accZ = findViewById(R.id.tv_accZ);
        tv_gyrX = findViewById(R.id.tv_gyrX);
        tv_gyrY = findViewById(R.id.tv_gyrY);
        tv_gyrZ = findViewById(R.id.tv_gyrZ);
        tv_heart = findViewById(R.id.tv_heart);
        btn_StartAndStop.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        if(btn_StartAndStop.getText().equals("Start")){
            toast = Toast.makeText(this, "START", Toast.LENGTH_SHORT);
            toast.show();
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            btn_StartAndStop.setText("Stop");
            btn_StartAndStop.setTextColor(Color.RED);
            btn_StartAndStop.setBackgroundColor(Color.GRAY);



        }
        else if(btn_StartAndStop.getText().equals("Stop")){
            toast = Toast.makeText(this, "STOP", Toast.LENGTH_SHORT);
            toast.show();
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.stop();
            tv_accX.setText("------");
            tv_accY.setText("------");
            tv_accZ.setText("------");
            tv_gyrX.setText("------");
            tv_gyrY.setText("------");
            tv_gyrZ.setText("------");
            tv_heart.setText("------");
            btn_StartAndStop.setText("Start");
            btn_StartAndStop.setTextColor(Color.BLACK);
            btn_StartAndStop.setBackgroundColor(Color.rgb(66,204,255));


        }
    }
}
