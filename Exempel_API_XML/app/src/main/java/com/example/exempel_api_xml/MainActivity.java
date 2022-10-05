package com.example.exempel_api_xml;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // private ArrayList<String> list = new ArrayList<>();
    private TextView cityText, sunText, tempText, skyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);

        cityText = findViewById(R.id.tv_city);
        sunText = findViewById(R.id.tv_sun);
        tempText = findViewById(R.id.tv_temp);
        skyText = findViewById(R.id.tv_sky);

        getData();
    }


    private void getData(){
        //list = new ArrayList<>();
        String city = "Karlstad";
        URL url;
        String API_KEY = "MY API KEY";

        try{
            url = new URL("https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + API_KEY + "&mode=xml");
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();
            String tagName;
            parser.setInput(url.openStream(), null);

            while(parserEvent != XmlPullParser.END_DOCUMENT){
                if(parserEvent == XmlPullParser.START_TAG){
                    tagName = parser.getName();
                    if(tagName.contains("country")){
                        Log.e("FOUND TAG", "TAG -> " + tagName);

                        parser.next();
                        String text = parser.getText();
                        Log.e("FOUND TEXT", "TEXT -> " + text);
                    }
                }
                parserEvent = parser.next();
            }
        }
        catch(IOException ex){
            Log.e("Error", "IOException: " + ex.toString());
        }
        catch(Exception ex){
            Log.e("Error", "Unknown2: " + ex.toString());
        }
    }
}