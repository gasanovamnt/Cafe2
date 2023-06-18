package com.example.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    val listFeatured = mutableListOf<FeaturedModel>()
    lateinit var recView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        listFeatured.add(
            FeaturedModel(
                "Bikram Yoga",
                "12 lessons",
                "Begineer",
                "",
                "https://i.imgur.com/gydn2Hz.png"
            )
        )
        listFeatured.add(
            FeaturedModel(
                "Bikram Yoga",
                "12 lessons",
                "Begineer",
                "",
                "https://i.imgur.com/CzBmdBk.png"
            )
        )

        recView = findViewById(R.id.rvFeatured)

        val adapter = FeaturedAdapter(listFeatured) { position ->
            removeFromList(position)
        }
        recView.adapter = adapter
    }

    fun removeFromList(position: Int) {
        listFeatured[position].count += 1
        recView.adapter?.notifyItemChanged(position)
    }

}
