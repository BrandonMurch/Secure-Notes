package com.brandonmurch.securenotes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayNoteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_note)

        val note: Note? = intent.getParcelableExtra("note")
        findViewById<TextView>(R.id.textViewNoteTitle).text = note?.title
        findViewById<TextView>(R.id.textViewNoteBody).text = note?.body
    }
}