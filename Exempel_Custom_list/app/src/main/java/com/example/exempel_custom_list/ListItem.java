package com.example.exempel_custom_list;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItem {

    private ImageView icon;
    private TextView text;
    private Button button;

    public ListItem(ImageView i, TextView t, Button b){
        icon = i;
        text = t;
        button = b;
    }


    public ImageView getIcon(){
        return icon;
    }

    public TextView getText(){
        return text;
    }

    public Button getButton(){
        return button;
    }

}
