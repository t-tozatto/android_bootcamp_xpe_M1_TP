package br.com.ttozatto.m1tp.ui.additems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import br.com.ttozatto.m1tp.R
import br.com.ttozatto.m1tp.databinding.ActivityAddItemBinding
import br.com.ttozatto.m1tp.databinding.ActivityMainBinding

class AddItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddItemBinding.inflate(layoutInflater)

        setContentView(binding.root)
        configureListeners()
    }

    private fun configureListeners() {
        binding.btnAddItem.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        if (!validateItem())
            return;

        Toast.makeText(
            applicationContext,
            "${binding.etProductName.text.toString()} - ${binding.etQuantity.text.toString()}",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }

    private fun validateItem() : Boolean {
        var result = true

        binding.apply {
            if (etProductName.text.isNullOrEmpty()) {
                tilProductName.error = getString(R.string.invalid_product)
                result = false
            } else
                tilProductName.error = null;

            if (etQuantity.text.isNullOrEmpty() || Integer.parseInt(etQuantity.text.toString()) <= 0) {
                tilQuantity.error = getString(R.string.invalid_quantity)
                result = false
            } else
                tilQuantity.error = null;
        }

        return result
    }
}