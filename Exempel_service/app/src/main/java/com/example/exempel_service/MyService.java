package com.example.exempel_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    @Override
    public void onStart(Intent intent, int startId){
        Log.d("MY SERVICE", "Service onStart()");
        for(int i = 0; i < 5; i++){
            Log.d("MY SERVICE", "Loopar varannan sekund, loop: " + i);
            synchronized (this){
                try{
                    wait(2000);
                }catch(Exception e){

                }
            }
        }
        stopSelf(startId);
    }

    public void onDestroy(){
        Log.d("MY SERVICE", "Service onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


    /*@Override
    public void onStart(Intent intent, int startId){
        for(int i = 0; i < 5; i++){
            Log.d("MY SERVICE", "Loopar varannan sekund, loop: " + i);
            synchronized (this){
                try{
                    wait(2000);
                }catch(Exception e){

                }
            }
        }
        stopSelf(startId);
    }*/