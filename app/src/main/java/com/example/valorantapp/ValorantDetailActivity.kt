package com.example.valorantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.valorantapp.databinding.ActivityValorantDetailBinding
import org.osmdroid.config.Configuration

class ValorantDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValorantDetailBinding

    companion object{
        val EXTRA_VALO = "valorant"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        binding = ActivityValorantDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}