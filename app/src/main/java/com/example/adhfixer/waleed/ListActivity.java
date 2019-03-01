package com.example.adhfixer.waleed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvCountries;
    ArrayList<String> arrayList=new ArrayList <>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvCountries = (ListView) findViewById(R.id.lvCountries);

        arrayList.add("Iberia");
        arrayList.add("Liszt");
        arrayList.add("Scaramouche");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvCountries.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
       String selectedItem= arrayList.get(position);
        Intent i = new Intent(this, Book1.class);
        i.putExtra("file", selectedItem);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}
