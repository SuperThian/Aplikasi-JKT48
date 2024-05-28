package com.example.jkt48

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail_Idol : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_idol)

        supportActionBar?.apply {
            title = getString(R.string.desc_page)
        }

        val photo = findViewById<ImageView>(R.id.img_photo)
        val name = findViewById<TextView>(R.id.item_name)
        val information = findViewById<TextView>(R.id.item_information)
        val jiko = findViewById<TextView>(R.id.item_jiko)

        val intentData = intent
        photo.setImageResource(intentData.getIntExtra("photo", 0))
        name.text = intentData.getStringExtra("name")
        information.text = intentData.getStringExtra("information")
        jiko.text = intentData.getStringExtra("jiko")
    }
}