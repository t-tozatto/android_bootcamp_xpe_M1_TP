package br.com.ttozatto.m1tp.data.repository

import br.com.ttozatto.m1tp.data.Product

class ProductMemoryRepository(list: MutableList<Product>) {
    private val memoryList: MutableList<Product> = list

    fun addProduct(product: Product){
        memoryList.add((product))
    }

    fun getAll() = memoryList.toList()
}