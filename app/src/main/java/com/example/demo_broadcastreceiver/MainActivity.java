package com.example.demo_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NetworkChangeReceiver mReceiver;
    private AirPlaneChange mPlaneMode;
    private Button mBtnSendBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBoadcastReceiver();
        mBtnSendBroadCast = findViewById(R.id.btnsendbroadcast);
        mBtnSendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCustomBroadcast();
            }
        });

    }


    public void sendCustomBroadcast() {
        Intent intent = new Intent(this,TestBroadCastActivity.class);
        intent.setAction("test.broadcast");
        sendBroadcast(intent);
        startActivity(intent);
    }


    private void registerBoadcastReceiver() {
        mReceiver = new NetworkChangeReceiver();
        final IntentFilter intentFilterNetWork = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mReceiver, intentFilterNetWork);

        mPlaneMode = new AirPlaneChange();
        final IntentFilter intentFilterAirPlane = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(mPlaneMode, intentFilterAirPlane);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mReceiver);
        unregisterReceiver(mPlaneMode);
    }
}
