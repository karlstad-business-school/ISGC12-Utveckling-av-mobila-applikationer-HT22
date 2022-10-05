package com.example.exempel_custom_list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Student> {

    private int layout;
    private List<Student> students;

    public CustomListAdapter(@NonNull Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        layout = resource;
        students = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ListItem main = null;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(layout, parent, false);

            ImageView icon = view.findViewById(R.id.list_item_image);
            TextView text = view.findViewById(R.id.list_item_text);
            Button button = view.findViewById(R.id.list_item_button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Button: " + students.get(position).getId(), Toast.LENGTH_SHORT).show();
                }
            });

            text.setText(students.get(position).getName());
            ListItem item = new ListItem(icon, text, button);
            view.setTag(item);

        }

        /*else{
            Log.e("TAG", "getView: " + getItem(position).getName() + " | " + view.getTag());
            main = (ListItem) view.getTag();
            main.getText().setText(getItem(position).getName());
        }*/

        return view;
    }
}
