package com.example.assesmen1_ppbm

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ListItemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item_detail)

        val intent = this.intent
        if (intent != null) {
            val artist = intent.getStringExtra("artist")
            val title = intent.getStringExtra("title")
            val image = intent.getIntExtra("image", R.drawable.acloudy1)
            val desc = intent.getIntExtra("desc", R.string.acloudyDesc1)

            val detailArist = findViewById<TextView>(R.id.listArtistsDetailed)
            val detailTitle = findViewById<TextView>(R.id.listTitlesDetailed)
            val detailImage = findViewById<ImageView>(R.id.listImagesDetailed)
            val detailDesc = findViewById<TextView>(R.id.listDescDetailed)


            detailArist.text = artist
            detailTitle.text = title
            detailImage.setImageResource(image)
            detailDesc.setText(desc)
        }
    }
}