package com.example.googlebooks.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebooks.R
import com.example.googlebooks.databinding.ItemBookBinding
import com.example.googlebooks.model.Volume
import com.squareup.picasso.Picasso


class BookListAdapter(
    private val items: List<Volume>,
    private val onItemClick: (Volume) -> Unit
) :
    RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    //Binding the elements with ViewBiding "ItemBookBinding" from layout: item_book
    class MyViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val volume = items[position]
        if (volume.volumeInfo.imageLinks?.smallThumbnail != null) {
            Picasso.get().load(volume.volumeInfo.imageLinks.smallThumbnail)
                .into(holder.binding.imgCover)
        } else {
            holder.binding.imgCover.setImageResource(R.drawable.ic_broke_image)
        }

        holder.binding.txtTitle.text = volume.volumeInfo.title
        holder.binding.txtAuthor.text = volume.volumeInfo.authors?.joinToString() ?: ""
        holder.binding.txtPages.text = volume.volumeInfo.pageCount?.toString() ?: ""


        holder.itemView.setOnClickListener {
            onItemClick(volume)
        }

    }
}