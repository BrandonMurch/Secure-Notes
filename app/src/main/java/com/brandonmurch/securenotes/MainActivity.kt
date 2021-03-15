package com.brandonmurch.securenotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brandonmurch.securenotes.NoteAdapter.OnNoteListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), OnNoteListener {

    private val notes = ArrayList<Note>()
    private val createNoteRequestCode = 1

    private fun mockNotes() {
        notes.add(Note("Test Note", "this is a note body."))
        notes.add(Note("Test Note 2", "electric boogaloo"))
    }

    private fun createNote(title: String, body: String) {
        notes.add(Note(title, body))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == this.createNoteRequestCode && resultCode == Activity.RESULT_OK) {
                createNote(data?.getStringExtra("title").orEmpty(), data?.getStringExtra("body").orEmpty())
        }
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
            startActivityForResult(Intent(this, CreateNoteActivity::class.java), createNoteRequestCode)
        }
    }

    override fun onNoteClick(position: Int) {
        val intent =  Intent(this, DisplayNoteActivity::class.java)
        intent.putExtra("note", notes[position])
        startActivity(intent)
    }

}