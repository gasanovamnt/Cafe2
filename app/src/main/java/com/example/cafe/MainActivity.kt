package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val listGood = mutableListOf<GoodModel>()
    lateinit var recView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listGood.add(GoodModel("Кофе", 320, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"))
        listGood.add(GoodModel("Кофе", 320, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"))
        listGood.add(GoodModel("Кофе", 320, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"))
        listGood.add(GoodModel("Кофе", 320, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"))
        listGood.add(GoodModel("Кофе", 320, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"))
        listGood.add(GoodModel("Кофе", 320, "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/flat-white-3402c4f.jpg"))

        recView = findViewById(R.id.rvGoods)

        val adapter = GoodsAdapter(listGood) { position ->
            removeFromList(position)
        }
        recView.adapter = adapter
    }

    fun removeFromList(position: Int){
        listGood[position].count += 1
        recView.adapter?.notifyItemChanged(position)
    }

    fun goToActivityHome(view: View) {
        val goToHomeActivityIntent = Intent(this, HomeActivity::class.java)
        startActivity(goToHomeActivityIntent)
    }

}
