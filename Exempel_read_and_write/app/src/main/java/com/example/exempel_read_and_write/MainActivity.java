package com.example.exempel_read_and_write;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private final String FILENAME = "file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToFile("Hello world ÖÖÖÖÖ ϗϗϗϗ");
        readFromFile();
    }
    //FileOutputStream fos = openFileOutput(FILENAME, MODE_APPEND);

    private void writeToFile(String data){
        try{
            FileOutputStream fos = openFileOutput(FILENAME, MODE_PRIVATE);
            fos.write(data.getBytes(StandardCharsets.US_ASCII));
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void readFromFile(){
        String line;
        StringBuilder res = new StringBuilder();

        try{
            InputStream in = openFileInput(FILENAME);
            if(in != null){
                InputStreamReader input = new InputStreamReader(in);
                BufferedReader buff = new BufferedReader(input);

                while((line = buff.readLine()) != null){
                    res.append(line);
                }

                in.close();
                Toast.makeText(getApplicationContext(), "FILE DATA: " + res.toString(), Toast.LENGTH_LONG).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}