package com.example.coddexaver.andronote;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

    //  private ArrayAdapter<NoteInfo> mAdapterNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));
            }
        });

      initializeDisplayContent();



    }

    @Override
    protected void onResume() {
        super.onResume();
        //   mAdapterNotes.notifyDataSetChanged();
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }
 private void initializeDisplayContent() {

     final RecyclerView recyclerNotes = findViewById(R.id.recycler_notes);
            final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
            recyclerNotes.setLayoutManager(notesLayoutManager);

            List<NoteInfo> notes = DataManager.getInstance().getNotes();
            mNoteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
            recyclerNotes.setAdapter(mNoteRecyclerAdapter);

    /*     final   ListView listNotes = findViewById(R.id.note_list);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mAdapterNotes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listNotes.setAdapter(mAdapterNotes);

    listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
           NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
intent.putExtra(NoteActivity.NOTE_POSITION, position);
            startActivity(intent);

    });
**/


}




}
