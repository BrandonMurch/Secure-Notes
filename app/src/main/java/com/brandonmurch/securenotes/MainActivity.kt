package com.brandonmurch.securenotes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brandonmurch.securenotes.NoteAdapter.OnNoteListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), OnNoteListener {

    private val notes = ArrayList<Note>()

    private fun mockNotes() {
        notes.add(Note("Test Note", "this is a note body."))
        notes.add(Note("Test Note 2", "electric boogaloo"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mockNotes()

        val recyclerView : RecyclerView = findViewById(R.id.recyclerNotes)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = NoteAdapter(notes, this)

        val createNoteButton : FloatingActionButton = findViewById(R.id.floatingButtonNewNote)
        createNoteButton.setOnClickListener {
            startActivity(Intent(this, CreateNoteActivity::class.java))
        }
    }

    override fun onNoteClick(position: Int) {
        val intent =  Intent(this, DisplayNoteActivity::class.java)
        intent.putExtra("note", notes[position])
        startActivity(intent)
    }

}