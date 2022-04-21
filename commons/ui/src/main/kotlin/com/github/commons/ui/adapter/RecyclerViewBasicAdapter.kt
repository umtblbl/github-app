package com.github.commons.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewBasicAdapter<T>(
    private val layoutId: Int,
    private val bindingModelName: Int,
    private val itemSelected: (T) -> Unit
) : RecyclerView.Adapter<RecyclerViewBasicAdapter<T>.ViewHolder>() {

    var list: List<T> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.setOnClickListener { itemSelected(list[position]) }
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder constructor(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any?) {
            binding.setVariable(bindingModelName, item)
            binding.executePendingBindings()
        }
    }
}
