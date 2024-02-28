package com.example.valorantapp

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.PopupMenu
import com.example.valorantapp.ValorantListActivity
import com.example.valorantapp.databinding.ActivityValorantListBinding

class ValorantDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValorantListBinding
    companion object{
        val EXTRA_VALO = "valorant"
    }

    @SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantListBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val weapon = intent.getParcelableExtra<WeaponSkinData>(EXTRA_VALO)
//        val name = weapon.displayName
//        val description = hero?.description
//        val superpower = hero?.superpower
//        val ranking = hero?.ranking.toString()
//        val image = hero?.image
//
//        binding.textView.text = name
//        binding.textViewHeroDetailDescriptionDescription.text = description
//        binding.textViewHeroDetailSuperpower.text = superpower
//        binding.textViewHeroDetailRanking.text = ranking
//        val uri = "@drawable/$image"
//        val imageResource = resources.getIdentifier(uri, null, packageName)
//        val logoDrawable = resources.getDrawable(imageResource, null)
//        binding.imageView.setImageDrawable(logoDrawable)
    }
}