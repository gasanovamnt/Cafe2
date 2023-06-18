package com.example.cafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox

class FeaturedAdapter(
    val featured: List<FeaturedModel>,
    val clickAddToBasket: ((Int) -> Unit)
) : RecyclerView.Adapter<FeaturedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_featured, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = featured.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(featured[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.featuredName)
        val amount: TextView = itemView.findViewById(R.id.featuredDescription)
        val level: TextView = itemView.findViewById(R.id.featuredDescription3)
        val loved: MaterialCheckBox = itemView.findViewById(R.id.featuredCheckbox)
        val img: ImageView = itemView.findViewById(R.id.featuredKid)

        fun bind(item: FeaturedModel) {
            name.text = item.name
            amount.text = item.amount
            loved.text = item.loved
            level.text = item.level

            Glide.with(itemView.context)
                .load(item.url)
                .placeholder(R.drawable.banner)
                .error(R.drawable.img2)
                .into(img)
        }
    }
}