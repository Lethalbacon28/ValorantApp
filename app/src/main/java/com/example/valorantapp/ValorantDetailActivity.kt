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
import com.example.valorantapp.databinding.ActivityValorantdetailBinding
import com.squareup.picasso.Picasso

class ValorantDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValorantdetailBinding
    companion object{
        val EXTRA_VALO = "valorantSkin"
    }

    @SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantdetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weapon = intent.getParcelableExtra<ValorantSkin>(EXTRA_VALO)!!
        val name = weapon.displayName
        var chromas = weapon.chromas
        var chroma1 = "No Chroma Available"
        var chroma2 = "No Chroma Available"
        var chroma3 = "No Chroma Available"
        var chroma4 = "No Chroma Available"

        if (chromas.size > 0) {
            chroma1 = "Chroma 1"
        }
        if (chromas.size > 1) {
            chroma2 = "Chroma 1"
        }
        if (chromas.size > 2) {
            chroma3 = "Chroma 1"
        }
        if (chromas.size > 3) {
            chroma4 = "Chroma 1"
        }

        binding.textViewValorantDetailSkinName.text = name
//        if (chroma1 != null) {
//            binding.buttonValorantDetailChroma1.text = chroma1.toString()
//        }
//        else {
//            binding.buttonValorantDetailChroma1.text = "No Chroma Available"
//        }
//        if (chroma2 != null) {
//            binding.buttonValorantDetailChroma2.text = chroma2.toString()
//        }
//        else {
//            binding.buttonValorantDetailChroma2.text = "No Chroma Available"
//        }
//        if (chroma3 != null) {
//            binding.buttonValorantDetailChroma3.text = chroma3.toString()
//        }
//        else {
//            binding.buttonValorantDetailChroma3.text = "No Chroma Available"
//        }
//        if (chroma4 != null) {
//            binding.buttonValorantDetailChroma4.text = chroma4.toString()
//        }
//        else {
//            binding.buttonValorantDetailChroma4.text = "No Chroma Available"
//        }
        binding.buttonValorantDetailChroma1.text = chroma1
        binding.buttonValorantDetailChroma2.text = chroma2
        binding.buttonValorantDetailChroma3.text = chroma3
        binding.buttonValorantDetailChroma4.text = chroma4
        Picasso.get().load(weapon.displayIcon).into(binding.imageViewValorantDetailIcon2)
        Picasso.get().load(weapon.contentTierUuid).into(binding.imageViewValorantDetailIcon)
    }
}