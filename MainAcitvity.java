package com.example.elavi.notes;

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
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> notes=new ArrayList<>();
    static ListView listView;
    static ArrayAdapter arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=this.getMenuInflater();
        menuInflater.inflate(R.menu.menu_resource,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
         if(R.id.addnote==item.getItemId())
         {
             Intent intent=new Intent(getApplicationContext(),NoteEditorActivity.class);
             startActivity(intent);
             return true;
         }
        else
         {
             return false;
         }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes.add("Add the note");
        listView=findViewById(R.id.listview);
        arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,notes);
       listView.setAdapter(arrayAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(MainActivity.this,NoteEditorActivity.class);
               intent.putExtra("noteid",i);
               startActivity(intent);
           }
       });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return true;
            }
        });
    }
}
