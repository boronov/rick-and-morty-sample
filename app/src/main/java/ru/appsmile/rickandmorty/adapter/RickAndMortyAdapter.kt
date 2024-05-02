package ru.appsmile.rickandmorty.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.appsmile.rickandmorty.R
import ru.appsmile.rickandmorty.ResultItem
import ru.appsmile.rickandmorty.databinding.ItemRickAndMortyBinding

class RickAndMortyAdapter(private val results: List<ResultItem>, private val listener: (item: ResultItem, name: String) -> Unit) :
    RecyclerView.Adapter<RickAndMortyAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRickAndMortyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemRickAndMortyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = results[position]
        with(holder.binding) {
            textViewName.text = currentItem.name

            Glide.with(holder.binding.root)
                .load(currentItem.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)

            textViewAliveStatus.text = "${currentItem.status} - ${currentItem.species}"

            val statusColor = when (currentItem.status) {
                "Dead" -> R.color.dead
                "Alive" -> R.color.live
                else -> R.color.unknown
            }

            textViewAliveStatus.compoundDrawableTintList =
                ColorStateList.valueOf(ContextCompat.getColor(root.context, statusColor))

            textViewLastKnownLocation.text = currentItem.origin.name
            textViewFirstKnownLocation.text = currentItem.location.name


            root.setOnClickListener {
                listener(currentItem, currentItem.name)
            }
        }
    }

}