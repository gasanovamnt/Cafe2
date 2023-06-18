package com.example.cafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class GoodsAdapter(
    val goods: List<GoodModel>,
    val clickAddToBasket : ((Int) -> Unit)
) : RecyclerView.Adapter<GoodsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_goods, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = goods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goods[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.goodName)
        val price: TextView = itemView.findViewById(R.id.goodPrice)
        val img: ImageView = itemView.findViewById(R.id.imgGood)
        val bye: MaterialButton = itemView.findViewById(R.id.bye)

        fun bind(item: GoodModel) {
            name.text = item.name
            price.text = "${item.price}"
            item.count?.let {
                bye.text = it.toString()
            }
            bye.setOnClickListener {
                clickAddToBasket.invoke(position)
            }

            Glide.with(itemView.context)
                .load(item.url)
                .placeholder(R.drawable.banner)
                .error(R.drawable.img2)
                .into(img)
        }
    }
}

