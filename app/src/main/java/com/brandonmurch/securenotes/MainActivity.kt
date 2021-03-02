package com.brandonmurch.securenotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private fun getNotes() : MutableList<Note> {
        val notes =  ArrayList<Note>()
        notes.add(Note("Test Note", "this is a note body."))
        notes.add(Note("Test Note 2", "electric boogaloo"))
        return notes
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerNotes)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = NoteAdapter(getNotes())
    }
}