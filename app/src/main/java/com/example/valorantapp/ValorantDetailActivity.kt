package com.example.valorantapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Context
import androidx.core.content.ContextCompat
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
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

//        if (chromas.size > 0) {
//            chroma1 = "Chroma 1"
//        }
//        if (chromas.size > 1) {
//            chroma2 = "Chroma 2"
//        }
//        if (chromas.size > 2) {
//            chroma3 = "Chroma 3"
//        }
//        if (chromas.size > 3) {
//            chroma4 = "Chroma 4"
//        }

        if(chromas.size >= 1) {
            Picasso.get().load(weapon.chromas[0].displayIcon).into(binding.imageButtonValorantDetailChroma1)
        }
        if(chromas.size >= 2){
            Picasso.get().load(weapon.chromas[1].displayIcon).into(binding.imageButtonValorantDetailChroma2)
        }
        if(chromas.size >= 3){
            Picasso.get().load(weapon.chromas[2].displayIcon).into(binding.imageButtonValorantDetailChroma3)
        }
        if(chromas.size >= 4){
            Picasso.get().load(weapon.chromas[3].displayIcon).into(binding.imageButtonValorantDetailChroma4)
        }
        if(chromas.size == 0){
            Picasso.get().load(weapon.displayIcon).into(binding.imageViewValorantDetailIcon)
        }
        binding.textViewValorantDetailSkinName.text = name
//       Picasso.get().load(weapon.chromas[0].displayIcon).into(binding.imageButtonValorantDetailChroma1)
//        Picasso.get().load(weapon.chromas[1].displayIcon).into(binding.imageButtonValorantDetailChroma2)
//        Picasso.get().load(weapon.chromas[2].displayIcon).into(binding.imageButtonValorantDetailChroma3)
//        Picasso.get().load(weapon.chromas[3].displayIcon).into(binding.imageButtonValorantDetailChroma4)
//        binding.imageButtonValorantDetailChroma1 = ImageView.setImage(Picasso.get().load(weapon.displayIcon).into(imageView))

//        binding.imagebuttonValorantDetailChroma2.text = chroma2
//        binding.buttonValorantDetailChroma3.text = chroma3
//        binding.buttonValorantDetailChroma4.text = chroma4
     //   Picasso.get().load(weapon.displayIcon).into(binding.imageViewValorantDetailIcon2)
        when(weapon.contentTierUuid){
            "0cebb8be-46d7-c12a-d306-e9907bfc5a25" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/0cebb8be-46d7-c12a-d306-e9907bfc5a25/displayicon.png").into(binding.imageViewValorantDetailIcon)
            "e046854e-406c-37f4-6607-19a9ba8426fc" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/e046854e-406c-37f4-6607-19a9ba8426fc/displayicon.png").into(binding.imageViewValorantDetailIcon)
            "60bca009-4182-7998-dee7-b8a2558dc369" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/60bca009-4182-7998-dee7-b8a2558dc369/displayicon.png").into(binding.imageViewValorantDetailIcon)
            "12683d76-48d7-84a3-4e09-6985794f0445" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/12683d76-48d7-84a3-4e09-6985794f0445/displayicon.png").into(binding.imageViewValorantDetailIcon)
            "411e4a55-4e59-7757-41f0-86a53f101bb5" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/411e4a55-4e59-7757-41f0-86a53f101bb5/displayicon.png").into(binding.imageViewValorantDetailIcon)
        }
//
//        binding.imageButtonValorantDetailChroma1.setOnClickListener {
//            val registrationIntent = Intent(this, ValorantChroma::class.java)
//            // 2. Optionally add information to send with the intent
//            registrationIntent.putExtra(ValorantChroma.EXTRA_VALO, weapon)
//            // 3. launch the new activity using the intent
//            this.startActivity(registrationIntent)
//            Toast.makeText(this, "You clicked Chroma 1", Toast.LENGTH_SHORT).show()
//        }
//        binding.buttonValorantDetailChroma2.setOnClickListener {
//            val registrationIntent = Intent(this, ValorantDetailActivity::class.java)
//            // 2. Optionally add information to send with the intent
//            registrationIntent.putExtra(ValorantDetailActivity.EXTRA_VALO, weapon)
//            // 3. launch the new activity using the intent
//            this.startActivity(registrationIntent)
//            Toast.makeText(this, "You clicked Chroma 2", Toast.LENGTH_SHORT).show()
//        }
//        binding.buttonValorantDetailChroma3.setOnClickListener {
//            val registrationIntent = Intent(this, ValorantDetailActivity::class.java)
//            // 2. Optionally add information to send with the intent
//            registrationIntent.putExtra(ValorantDetailActivity.EXTRA_VALO, weapon)
//            // 3. launch the new activity using the intent
//            this.startActivity(registrationIntent)
//            Toast.makeText(this, "You clicked Chroma 3", Toast.LENGTH_SHORT).show()
//        }
//        binding.buttonValorantDetailChroma4.setOnClickListener {
//            val registrationIntent = Intent(this, ValorantDetailActivity::class.java)
//            // 2. Optionally add information to send with the intent
//            registrationIntent.putExtra(ValorantDetailActivity.EXTRA_VALO, weapon)
//            // 3. launch the new activity using the intent
//            this.startActivity(registrationIntent)
//            Toast.makeText(this, "You clicked Chroma 4", Toast.LENGTH_SHORT).show()
//        }
    }
}