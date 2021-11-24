package com.daniel.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daniel.myapplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hewan = intent.getParcelableExtra<Hewan>("data")

        with(binding){
            if (hewan != null) {
                imageView2.setImageResource(hewan.image)
                title.text = hewan.title
                description.text = hewan.description
            }
        }
    }
}