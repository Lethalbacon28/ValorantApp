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
        val EXTRA_NUMBER = "number"
    }

    @SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantdetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weapon = intent.getParcelableExtra<ValorantSkin>(EXTRA_VALO)!!
        val name = weapon.displayName
        var chromas = weapon.chromas

        if(chromas.size >= 1) {
            Picasso.get().load(weapon.displayIcon).into(binding.imageButtonValorantDetailChroma1)
        }
        if(chromas.size >= 2){
            Picasso.get().load(weapon.chromas[1].fullRender).into(binding.imageButtonValorantDetailChroma2)
            if (chromas[1].streamedVideo == null) {
                binding.textViewValorantDetailText3.text = "No Video"
            }
        }
        else {
            binding.textViewValorantDetailText3.text = ""
        }
        if(chromas.size >= 3){
            Picasso.get().load(weapon.chromas[2].fullRender).into(binding.imageButtonValorantDetailChroma3)
            if (chromas[2].streamedVideo == null) {
                binding.textViewValorantDetailText4.text = "No Video"
            }
        }
        else {
            binding.textViewValorantDetailText4.text = ""
        }
        if(chromas.size >= 4){
            Picasso.get().load(weapon.chromas[3].fullRender).into(binding.imageButtonValorantDetailChroma4)
            if (chromas[3].streamedVideo == null) {
                binding.textViewValorantDetailText5.text = "No Video"
            }
        }
        else {
            binding.textViewValorantDetailText5.text = ""
        }
        if(chromas.size == 0){
            Picasso.get().load(weapon.chromas[0].fullRender).into(binding.imageViewValorantDetailIcon)
        }

        if (weapon.levels[0].streamedVideo == null) {
            binding.textViewValorantDetailText.text = "No Video"
        }

        if (chromas.size > 0 && chromas[0].streamedVideo == null) {
            if (weapon.levels[weapon.levels.size-1].streamedVideo == null) {
                binding.imageButtonValorantDetailChroma1.setEnabled(false)
            }
        }
        if (chromas.size > 1 && chromas[1].streamedVideo == null) {
            binding.imageButtonValorantDetailChroma2.setEnabled(false)
        }
        if (chromas.size > 2 && chromas[2].streamedVideo == null) {
            binding.imageButtonValorantDetailChroma3.setEnabled(false)
        }
        if (chromas.size > 3 && chromas[3].streamedVideo == null) {
            binding.imageButtonValorantDetailChroma4.setEnabled(false)
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

        binding.imageButtonValorantDetailChroma1.setOnClickListener {
            val registrationIntent = Intent(this, ValorantChroma::class.java)
            // 2. Optionally add information to send with the intent
            registrationIntent.putExtra(ValorantChroma.EXTRA_VALO, weapon)
            registrationIntent.putExtra(ValorantChroma.EXTRA_NUMBER, 0)
            // 3. launch the new activity using the intent
            this.startActivity(registrationIntent)
            Toast.makeText(this, "You clicked Chroma 1", Toast.LENGTH_SHORT).show()
        }
        binding.imageButtonValorantDetailChroma2.setOnClickListener {
            val registrationIntent = Intent(this, ValorantChroma::class.java)
            // 2. Optionally add information to send with the intent
            registrationIntent.putExtra(ValorantChroma.EXTRA_VALO, weapon)
            registrationIntent.putExtra(ValorantChroma.EXTRA_NUMBER, 1)
            // 3. launch the new activity using the intent
            this.startActivity(registrationIntent)
            Toast.makeText(this, "You clicked Chroma 2", Toast.LENGTH_SHORT).show()
        }
        binding.imageButtonValorantDetailChroma3.setOnClickListener {
            val registrationIntent = Intent(this, ValorantChroma::class.java)
            // 2. Optionally add information to send with the intent
            registrationIntent.putExtra(ValorantChroma.EXTRA_VALO, weapon)
            registrationIntent.putExtra(ValorantChroma.EXTRA_NUMBER, 2)
            // 3. launch the new activity using the intent
            this.startActivity(registrationIntent)
            Toast.makeText(this, "You clicked Chroma 3", Toast.LENGTH_SHORT).show()
        }
        binding.imageButtonValorantDetailChroma4.setOnClickListener {
            val registrationIntent = Intent(this, ValorantChroma::class.java)
            // 2. Optionally add information to send with the intent
            registrationIntent.putExtra(ValorantChroma.EXTRA_VALO, weapon)
            registrationIntent.putExtra(ValorantChroma.EXTRA_NUMBER, 3)
            // 3. launch the new activity using the intent
            this.startActivity(registrationIntent)
            Toast.makeText(this, "You clicked Chroma 4", Toast.LENGTH_SHORT).show()
        }
    }
}