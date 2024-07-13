package com.example.listviewdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        String[] name = {"Sachintha Nimesh", "Dumindu Lakshan", "Vimukthi Lakshan", "Nimesh Dev", "Shay Cormac", "Dumindu Lakshan Wikramasinghe", "Sachintha Nimesh", "Dumindu Lakshan", "Vimukthi Lakshan", "Nimesh Dev", "Shay Cormac", "Dumindu Lakshan Wikramasinghe"};
        String[] description = {"077 851 9573", "071 055 8339", "072 234 2324", "077 851 9573", "071 055 8339", "072 234 2324", "077 851 9573", "071 055 8339", "072 234 2324", "077 851 9573", "071 055 8339", "072 234 2324"};
        int[] profilerPict = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};

        CustomAdapter customAdapter = new CustomAdapter(this, name, description, profilerPict);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent activityShowContact = new Intent(getApplicationContext(), ActivityViewContact.class);
                Bundle contactDetails = new Bundle();

                contactDetails.putString("NAME", name[position]);
                contactDetails.putString("DESCRIPTION", description[position]);
                contactDetails.putInt("IMG", profilerPict[position]);

                activityShowContact.putExtras(contactDetails);
                startActivity(activityShowContact);
            }
        });
    }
}

class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    String[] name, description;
    int[] profilePict;

    CustomAdapter(Context context, String[] name, String[] description, int[] profilePict){
        super(context, R.layout.simple_single_list_view, R.id.txtName, name);
        this.context = context;
        this.name = name;
        this.description = description;
        this.profilePict = profilePict;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(R.layout.simple_single_list_view, parent, false);

        ImageView ivProfilePict = view.findViewById(R.id.imgView);
        TextView txtName = view.findViewById(R.id.txtName),
                txtDescription = view.findViewById(R.id.txtDescription);

        ivProfilePict.setImageResource(profilePict[position]);
        txtName.setText(name[position]);
        txtDescription.setText(description[position]);

        return view;
    }
}