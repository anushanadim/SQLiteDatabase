package com.example.anushanadim.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Display extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;
    ContactsViewAdapter adapter;
    List<Contacts> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        contactsList=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);

        databaseHelper=new DatabaseHelper(this,DatabaseHelper.DATABASE,null,1);
        contactsList=databaseHelper.show();
        adapter=new ContactsViewAdapter(contactsList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
