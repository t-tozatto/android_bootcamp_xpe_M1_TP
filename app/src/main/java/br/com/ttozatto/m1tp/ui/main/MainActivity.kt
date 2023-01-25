package br.com.ttozatto.m1tp.ui.main

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import br.com.ttozatto.m1tp.data.Product
import br.com.ttozatto.m1tp.databinding.ActivityMainBinding
import br.com.ttozatto.m1tp.ui.additems.AddItemActivity

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val productReturn = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        handleActivityResult(activityResult)
    }

    private fun handleActivityResult(activityResult: ActivityResult?) {
        if (activityResult?.resultCode == RESULT_OK) {
            activityResult.data?.let {
                if (it.hasExtra(RESULT_ADD_ITEM)) {
                    val productData =
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            it.getParcelableExtra(RESULT_ADD_ITEM, Product::class.java)
                        } else {
                            it.getParcelableExtra(RESULT_ADD_ITEM)
                        }

                    viewModel.saveProduct(productData!!)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initializeData()
        configureListeners()
        configureObservers()
    }

    private fun configureObservers() {
        configureListUpdate()
    }

    private fun configureListUpdate() {
        viewModel.productList.observe(this) {
            if (it.isNullOrEmpty())
                visibilityEmptyMessage(true)
            else {
                visibilityEmptyMessage(false)
                binding.rvProducts.adapter = ProductAdapter(it)
            }
        }
    }

    private fun visibilityEmptyMessage(visibility: Boolean) {
        binding.apply {
            tvEmptyList.visibility = if (visibility) View.VISIBLE else View.GONE
            rvProducts.visibility = if (visibility) View.GONE else View.VISIBLE
        }
    }

    private fun initializeData() {
        viewModel.getAll()
    }

    private fun configureListeners() {
        binding.fabNewItem.setOnClickListener {
            openActivityNewItem()
        }
    }

    private fun openActivityNewItem() {
        Intent(this, AddItemActivity::class.java).let {
            productReturn.launch(it)
        }
    }

    companion object {
        const val RESULT_ADD_ITEM = "ADD_ITEM_OBJECT"
    }
}