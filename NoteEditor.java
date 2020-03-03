package com.example.elavi.notes;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import static android.media.CamcorderProfile.get;
public class NoteEditorActivity extends AppCompatActivity {
    EditText editText;
    int noteid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        editText = findViewById(R.id.editText);
        Intent intent = getIntent();
         noteid = intent.getIntExtra("noteid", -1);
        if (noteid != -1) {
            String text = MainActivity.notes.get(noteid);
            editText.setText(text);

           Toast.makeText(getApplicationContext(),"The arraylist content is"+MainActivity.notes.get(noteid),Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Here we go",Toast.LENGTH_SHORT).show();
            MainActivity.notes.add("");
            noteid=MainActivity.notes.size()-1;
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (noteid != -1) {
                    MainActivity.notes.set(noteid, String.valueOf(charSequence));
                    MainActivity.arrayAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

