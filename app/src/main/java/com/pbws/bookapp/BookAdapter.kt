package com.pbws.bookapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pbws.bookapp.databinding.BookItemBinding

class BookAdapter(var list: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun getItemCount() = list.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(position)
    }

    inner class ViewHolder(var bookItemBinding: BookItemBinding) :
        RecyclerView.ViewHolder(bookItemBinding.root) {
        fun bind(position: Int) {
            val book = list[position]
            bookItemBinding.bookTitle.text = book.title
            bookItemBinding.bookSubtitle.text = book.author
            bookItemBinding.ratingbar.rating= book.rating
            bookItemBinding.bookImg.setImageResource(book.img)
        }
    }
}