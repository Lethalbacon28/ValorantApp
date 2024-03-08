package com.example.valorantapp

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ValorantAdapter(private var skinList: Data) : RecyclerView.Adapter<ValorantAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val skinName: TextView
        val skinIcon: ImageView
        val contentTier: ImageView
        val layout: ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View
            skinName = view.findViewById(R.id.textView_item_name)
            skinIcon = view.findViewById(R.id.imageView_item_displayIcon)
            contentTier = view.findViewById(R.id.imageView_item_contentTier)
            layout = view.findViewById(R.id.layout_valorantlist)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValorantAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_valorantlist, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ValorantAdapter.ViewHolder, position: Int) {
        val context = holder.layout.context
        val valoSkin = skinList.data?.get(position)!!
        holder.skinName.text = valoSkin.displayName
        // Picasso.with(context).load(skinList.displayIcon).into(imageView)
        Picasso.get().load(valoSkin.displayIcon).into(holder.skinIcon)
        Log.d("Adapter", "${valoSkin}")
        when(valoSkin.contentTierUuid){
            "0cebb8be-46d7-c12a-d306-e9907bfc5a25" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/0cebb8be-46d7-c12a-d306-e9907bfc5a25/displayicon.png").into(holder.contentTier)
            "e046854e-406c-37f4-6607-19a9ba8426fc" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/e046854e-406c-37f4-6607-19a9ba8426fc/displayicon.png").into(holder.contentTier)
            "60bca009-4182-7998-dee7-b8a2558dc369" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/60bca009-4182-7998-dee7-b8a2558dc369/displayicon.png").into(holder.contentTier)
            "12683d76-48d7-84a3-4e09-6985794f0445" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/12683d76-48d7-84a3-4e09-6985794f0445/displayicon.png").into(holder.contentTier)
            "411e4a55-4e59-7757-41f0-86a53f101bb5" -> Picasso.get().load("https://media.valorant-api.com/contenttiers/411e4a55-4e59-7757-41f0-86a53f101bb5/displayicon.png").into(holder.contentTier)
        }
      //  Picasso.get().load(valoSkin.contentTier.displayIcon).into(holder.contentTier)
//        val uri = "@drawable/$image"
//        val imageResource = resources.getIdentifier(uri, null, packageName)
//        val logoDrawable = resources.getDrawable(imageResource, null)
//        holder.skinIcon.setImageDrawable(logoDrawable)

        holder.layout.setOnClickListener {
            val registrationIntent = Intent(context, ValorantDetailActivity::class.java)
            // 2. Optionally add information to send with the intent
            registrationIntent.putExtra(ValorantDetailActivity.EXTRA_VALO, valoSkin)
            // 3. launch the new activity using the intent
            context.startActivity(registrationIntent)
            Toast.makeText(context, "You clicked ${valoSkin.displayName}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = skinList.data!!.size
}