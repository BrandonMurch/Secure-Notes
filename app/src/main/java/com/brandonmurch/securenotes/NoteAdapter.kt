package com.brandonmurch.securenotes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: MutableList<Note>, private val onNoteListener: OnNoteListener) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.note_card, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.textNoteTitle.text = currentNote.title
        holder.textNoteBody.text = currentNote.body
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textNoteTitle: TextView = view.findViewById(R.id.textNoteTitle)
        val textNoteBody: TextView = view.findViewById(R.id.textNoteBody)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteListener.onNoteClick(adapterPosition)
        }


    }

    interface OnNoteListener{
        fun onNoteClick(position: Int)
    }
}