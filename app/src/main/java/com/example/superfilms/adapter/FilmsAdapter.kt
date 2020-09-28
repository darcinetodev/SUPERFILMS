package com.example.superfilms.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superfilms.R
import com.example.superfilms.model.Results
import com.squareup.picasso.Picasso

class FilmsAdapter(
    private var listFilms: List<Results>?
) : RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val itemList = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_film, parent, false)

        return FilmsViewHolder(itemList)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${listFilms?.get(position)?.posterPath}").into(holder.image)
        holder.title.text = listFilms?.get(position)?.title
        holder.details.text = listFilms?.get(position)?.overview
        holder.date.text = listFilms?.get(position)?.releaseDate
    }

    override fun getItemCount(): Int {
        return listFilms!!.size
    }

    class FilmsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image_film)
        var title: TextView = itemView.findViewById(R.id.title_film)
        var details: TextView = itemView.findViewById(R.id.detail_film)
        var date: TextView = itemView.findViewById(R.id.date_film)
    }

}