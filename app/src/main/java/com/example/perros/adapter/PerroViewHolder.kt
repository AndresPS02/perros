package com.example.perros.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.perros.databinding.PerroRenglonBinding
import com.squareup.picasso.Picasso

class PerroViewHolder (view : View) : RecyclerView.ViewHolder(view){
    private val binding = PerroRenglonBinding.bind(itemView)
    fun bind(imageString: String){
        Glide.with(binding.root)
            .load(imageString).centerCrop()
            .into(binding.fotoPerro)
        //Picasso.get().load(imageString).into(binding.fotoPerro)
    }

}