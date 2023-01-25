package br.com.ttozatto.m1tp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ttozatto.m1tp.data.Product
import br.com.ttozatto.m1tp.data.repository.ProductMemoryRepository

class MainViewModel: ViewModel() {
    private var productMemoryRepository: ProductMemoryRepository = ProductMemoryRepository(mutableListOf())
    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productList;

    fun getAll(){
        _productList.value = productMemoryRepository.getAll()
    }

    fun saveProduct(product: Product){
        productMemoryRepository.addProduct(product)
        updateList()
    }

    private fun updateList() {
        _productList.value = productMemoryRepository.getAll()
    }
}