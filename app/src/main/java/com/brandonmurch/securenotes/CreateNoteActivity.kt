package com.brandonmurch.securenotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_note)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.create_note_menu_items, menu)
        return true
    }

    private fun createNote(intent: Intent) {
        intent.putExtra("title", findViewById<EditText>(R.id.editTextNoteTitle).text.toString())
        intent.putExtra("body", findViewById<EditText>(R.id.editTextMultiLineNoteBody).text.toString())
        setResult(Activity.RESULT_OK, intent)
    }
    private fun deleteNote(intent: Intent) {
        setResult(Activity.RESULT_CANCELED, intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent()
        when (item.itemId) {
            R.id.menuItemCreateNote ->  createNote(intent)
            R.id.menuItemDeleteNote -> deleteNote(intent)
        }
        finish()
        return true
    }
}