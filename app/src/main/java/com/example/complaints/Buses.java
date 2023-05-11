package com.example.complaints;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;








import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class Buses extends ListActivity {

    private ListView listView;
    private String countryNames[] = {
            "Navadurga Prasad",
            "Navadurga",
            "Navadurga",
            "Reshma",
            "Laxmi Ganesh",
            "Vishal",
            "Lakshmi Ganesh",
            "Vishal",
            "Gopal",
            "Padmambika",
            "Padmambika",
            "Padmambika",
            "Padmambika",
            "Rajeraj",
            "Vishal",
            "Vishal"

    };

    private String capitalNames[] = {
            "6:50 am",
            "7:00 am",
            "7:10 am",
            "7:15 am",
            "7:20 am",
            "7:30 am",
            "7:50 am",
            "7:57 am",
            "8:05 am",
            "8:15 am",
            "8:25 am",
            "8:30 am",
            "8:45 am",
            "9:00 am",
            "9:25 am",
            "9:35 am",
            "9:50 am",
            "10:50 am"

    };

    private Integer imageid[] = {
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24,
            R.drawable.ic_baseline_directions_bus_24

    };

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses);

        TextView textView = new TextView(this);
//        textView.setTypeface(Typeface.DEFAULT_BOLD);


        ListView listView=(ListView)findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        CustomList customCountryList = new CustomList(this, countryNames, capitalNames, imageid);
        listView.setAdapter(customCountryList);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(getApplicationContext(),"You Selected "+countryNames[position-1]+ " as Country",Toast.LENGTH_SHORT).show();        }
//        });

    }
}