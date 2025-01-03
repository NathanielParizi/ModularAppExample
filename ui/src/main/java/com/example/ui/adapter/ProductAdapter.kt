package com.example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.data.model.Product
import com.example.ui.databinding.ItemProductBinding

class ProductAdapter(
        private val onProductClick: (Product) -> Unit
) : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
            holder: ProductViewHolder,
            position: Int
    ) {
        holder.bind(getItem(position))
    }

    inner class ProductViewHolder(
            private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onProductClick(getItem(position))
                }
            }
        }

        fun bind(product: Product) {
            binding.product = product

            // Load product thumbnail
            Glide.with(binding.root.context)
                .load(product.thumbnail)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.productImageView)

            binding.executePendingBindings()
        }
    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(
                oldItem: Product,
                newItem: Product
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
                oldItem: Product,
                newItem: Product
        ): Boolean {
            return oldItem == newItem
        }
    }
} 