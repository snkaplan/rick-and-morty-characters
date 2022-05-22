package com.sk.rickandmortyapi.ui.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.sk.rickandmortyapi.R
import com.sk.rickandmortyapi.data.model.Character
import com.sk.rickandmortyapi.databinding.RvItemBinding

class MainAdapter(val charactersList: List<Character>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = RvItemBinding.bind(itemView)
        fun bindData(character: Character){
            binding.name.text = character.name
            binding.image.load(character.image){
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        // Access with this way
/*        with(holder){
            binding.
        }*/
        holder.bindData(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}