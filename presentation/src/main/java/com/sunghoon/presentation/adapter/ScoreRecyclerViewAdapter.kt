package com.sunghoon.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunghoon.domain.model.DomainScore
import com.sunghoon.presentation.R
import com.sunghoon.presentation.databinding.ScoreRecyclerviewItemBinding
import com.sunghoon.presentation.viewmodel.MainViewModel

class ScoreRecyclerViewAdapter(
    private val viewModel: MainViewModel
)  : RecyclerView.Adapter<ScoreRecyclerViewAdapter.ScoreRecyclerViewHolder>() {

    inner class ScoreRecyclerViewHolder(val binding : ScoreRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : DomainScore){
            binding.data = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreRecyclerViewHolder {
        val layoutInflater  = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ScoreRecyclerviewItemBinding>(
            layoutInflater,
            R.layout.score_recyclerview_item,
            parent,
            false
        )
        return ScoreRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.scoreList.size
    }

    override fun onBindViewHolder(holder: ScoreRecyclerViewHolder, position: Int) {
        holder.bind(viewModel.scoreList[position])
    }
}