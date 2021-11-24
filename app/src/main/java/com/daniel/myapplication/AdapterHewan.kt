package com.daniel.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniel.myapplication.databinding.ItemViewBinding

class AdapterHewan:RecyclerView.Adapter<AdapterHewan.ViewHolder>() {

    private val listHewan = ArrayList<Hewan>()

    class ViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(hewan: Hewan){
            with(binding){
                title.text = hewan.title
                imageView.setImageResource(hewan.image)
            }
        }
    }

    fun setData(listHewan:List<Hewan>){
        this.listHewan.clear()
        this.listHewan.addAll(listHewan)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHewan[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("data", listHewan[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listHewan.size
}