package com.example.googlebooks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.googlebooks.R
import com.example.googlebooks.databinding.ActivityBookDetailBinding
import com.example.googlebooks.model.Volume
import com.squareup.picasso.Picasso

class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val volume = intent.getParcelableExtra<Volume>(EXTRA_BOOK)

        if (volume != null) {
            if (volume.volumeInfo.imageLinks?.smallThumbnail != null) {
                Picasso.get().load(volume.volumeInfo.imageLinks.smallThumbnail)
                    .into(binding.imgCover)
            } else {
                binding.imgCover.setImageResource(R.drawable.ic_broke_image)
            }

            binding.txtTitle.text = volume.volumeInfo.title
            binding.txtAuthor.text = volume.volumeInfo.authors?.joinToString() ?: ""
            binding.txtPages.text = volume.volumeInfo.pageCount?.toString() ?: ""
            binding.description.text = volume.volumeInfo.description
            binding.txtPublisher.text = volume.volumeInfo.publisher

        } else {
            Log.d("TAG", "onCreate: nnnnnnnnnnnn deueueueueueu")
        }

    }

    companion object {
        private const val EXTRA_BOOK = "book"

    }
}