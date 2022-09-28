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
        String API_KEY = "343cf30f827898c02af872a00bf3528e";

        try{
            url = new URL("https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + API_KEY + "&mode=xml");
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();
            String tagName;

            while(parserEvent != XmlPullParser.END_DOCUMENT){
                if(parserEvent == XmlPullParser.START_TAG){
                    tagName = parser.getName();
                    if (tagName.equals("city")) {
                        cityText.setText("City: "+parser.getAttributeValue(1));
                    }
                    if (tagName.equals("sun")) {
                        sunText.setText("Sun rises: "+parser.getAttributeValue(0));
                    }
                    if (tagName.equals("temperature")) {
                        tempText.setText("Temperature: "+(Float.parseFloat(parser.getAttributeValue(1))- 273.15));
                    }
                    if (tagName.equals("clouds")) {
                        skyText.setText("Sky: "+parser.getAttributeValue(1));
                    }

                    /*Log.d("XML", "Start tag found: " + tagName);
                    Log.d("XML", "Text found: " + parser.nextText());
                    int count = parser.getAttributeCount();
                    if(count > 0){
                        Log.d("XML", "Attribute found: " + parser.getAttributeName(0));
                    }
                    Log.d("XML", "Attribute value found: " + parser.getAttributeValue(null, "id"));
        */
                }

                parserEvent = parser.next();
            }
        } catch (MalformedURLException | XmlPullParserException e) {
            e.printStackTrace();
            Log.e("XML", e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("XML", e.toString());
        }
    }
}