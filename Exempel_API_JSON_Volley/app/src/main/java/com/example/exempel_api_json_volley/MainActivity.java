package com.example.exempel_api_json_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements VolleyCallback{

    private APICall apiCall;
    private RequestQueue requestQueue;

    private TextView cityText, skyText, tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityText = findViewById(R.id.city_tv);
        skyText = findViewById(R.id.sky_tv);
        tempText = findViewById(R.id.temp_tv);

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        String url = "https://api.openweathermap.org/data/2.5/weather?q=karlstad&appid=343cf30f827898c02af872a00bf3528e&mode=json";

        apiCall = new APICall();
        apiCall.get(requestQueue, this, url);

    }

    @Override
    public void onSucess(JSONObject object) {
        try{
            String name = object.get("name").toString();
            String temp = object.getJSONObject("main").get("temp").toString();

            JSONArray weather = object.getJSONArray("weather");
            String sky = weather.getJSONObject(0).get("main").toString();

            cityText.setText(name);
            tempText.setText(temp);
            skyText.setText(sky);

        }catch (Exception e){
            Log.e("ERROR", e.toString());
        }
    }

    @Override
    public void onFailure(Exception e) {
        Log.e("ERROR FAIL", e.toString());
    }
}

//API-key: 343cf30f827898c02af872a00bf3528e