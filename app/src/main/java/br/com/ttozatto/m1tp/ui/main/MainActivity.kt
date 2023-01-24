package br.com.ttozatto.m1tp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ttozatto.m1tp.R
import br.com.ttozatto.m1tp.databinding.ActivityMainBinding
import br.com.ttozatto.m1tp.ui.additems.AddItemActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        configureListeners()
    }

    private fun configureListeners() {
        binding.fabNewItem.setOnClickListener{
            openActivityNewItem()
        }
    }

    private fun openActivityNewItem() {
        startActivity(Intent(this, AddItemActivity::class.java))
    }
}