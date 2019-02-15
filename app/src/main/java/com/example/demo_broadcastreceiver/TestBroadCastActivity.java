package com.example.demo_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class TestBroadCastActivity extends AppCompatActivity {
    private Broadcast mBroadcast;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testbroadcast);
        mBroadcast = new Broadcast();
        IntentFilter filter = new IntentFilter("test.broadcast");
        registerReceiver(mBroadcast,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mBroadcast);
    }
}
