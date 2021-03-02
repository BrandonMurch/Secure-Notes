package com.brandonmurch.securenotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: MutableList<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.note_card, parent, false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.textNoteTitle.text = currentNote.title
        holder.textNoteBody.text = currentNote.body
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textNoteTitle: TextView = view.findViewById(R.id.textNoteTitle)
        val textNoteBody: TextView = view.findViewById(R.id.textNoteBody)
    }
}