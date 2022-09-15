package com.example.exempel_async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private Context ctx;


    public MyAsyncTask(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected Void doInBackground(Void... params) {
        for(int i = 0; i < 10; i++){
            synchronized (this){
                try{
                    Log.d("MyAsyncTask", "Waiting for task: " + i);
                    wait(250);
                }catch(Exception e){

                }
            }
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void result){
        super.onPostExecute(result);

        Intent back = new Intent(ctx, MainActivity.class);
        back.putExtra("result", "Hello from AsyncTask");
        back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(back);
    }
}
