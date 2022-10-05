package com.example.hantera_data_v3;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListItem {
    private ImageView image;
    private TextView text;
    private Button button;

    public ListItem(ImageView i, TextView t, Button b){
        image = i;
        text = t;
        button = b;
    }

    public ImageView getImage(){
        return image;
    }

    public TextView getText(){
        return text;
    }

    public Button getButton(){
        return button;
    }
}
