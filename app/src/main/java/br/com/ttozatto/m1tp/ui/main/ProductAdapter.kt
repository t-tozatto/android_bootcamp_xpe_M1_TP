package br.com.ttozatto.m1tp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ttozatto.m1tp.data.Product
import br.com.ttozatto.m1tp.databinding.ListProductsBinding

class ProductAdapter(private val productList: List<Product>)
    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

        private lateinit var binding: ListProductsBinding

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
            fun bind(product: Product){
                binding.apply {
                    tvProduct.text = product.Name
                    tvQuantity.text = product.Quantity.toString()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListProductsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(product = productList[position])
    }
}