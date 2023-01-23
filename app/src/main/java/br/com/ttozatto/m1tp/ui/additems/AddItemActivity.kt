package br.com.ttozatto.m1tp.ui.additems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ttozatto.m1tp.databinding.ActivityAddItemBinding
import br.com.ttozatto.m1tp.databinding.ActivityMainBinding

class AddItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddItemBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}