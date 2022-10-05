package com.example.hantera_data_v3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends ArrayAdapter<Student> {

    private int layout;
    private List<Student> students;

    public StudentListAdapter(@NonNull Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        layout = resource;
        students = objects;
    }

    public void update(ArrayList<Student> s){
        students = s;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ListItem main = null;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(layout, parent, false);

            ImageView image = view.findViewById(R.id.list_item_image);
            TextView text = view.findViewById(R.id.list_item_text);
            Button button = view.findViewById(R.id.list_item_button);

            ListItem item = new ListItem(image, text, button);
            set(item, position);
            view.setTag(item);
        }else{
            main = (ListItem) view.getTag();
            set(main, position);
        }

        return view;
    }


    private void set(ListItem li, int position){
        li.getText().setText(students.get(position).getName());

        li.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Button: " + position, Toast.LENGTH_SHORT).show();

                Database.getInstance().remove(students.get(position).getId());
                update(Database.getInstance().getStudents());
            }
        });
    }
}
