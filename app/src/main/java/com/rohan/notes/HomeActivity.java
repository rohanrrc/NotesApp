package com.rohan.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Note> notes = new ArrayList<Note>();
    NoteAdapter adapter = new NoteAdapter(this, notes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Intent intent = new Intent(this, AddActivity.class);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(sglm);


        addSomeNotes();

        NoteAdapter adapter = new NoteAdapter(HomeActivity.this, notes);
        recyclerView.setAdapter(adapter);

//        adapter.notifyDataSetChanged();

//        gv.setAdapter(adapter);
//        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(HomeActivity.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void addSomeNotes() {
        notes.add(new Note("To buy", "only some stuff", "fwefwef"));
        notes.add(new Note("Hi hi hi", "What is up\n\n\nwfnwef\newfwe\n"));
        notes.add(new Note("Hello there", "What is up", "Blah blah bah", "lmao", "ello","bye", "hi","eh"));
        notes.add(new Note("", "bfiw wejknfwekjf\nofwneofw"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
