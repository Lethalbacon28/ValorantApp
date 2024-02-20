package com.example.valorantapp

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ValorantAdapter(private var skinList: WeaponSkinData) : RecyclerView.Adapter<ValorantAdapter.ViewHolder>() {
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

    @SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ValorantAdapter.ViewHolder, position: Int) {
        val context = holder.layout.context
        holder.skinName.text = skinList.displayName
        val uri = "@drawable/$image"
        val imageResource = resources.getIdentifier(uri, null, packageName)
        val logoDrawable = resources.getDrawable(imageResource, null)
        holder.skinIcon.setImageDrawable(logoDrawable)

        holder.layout.setOnClickListener {
            val registrationIntent = Intent(context, ValorantDetailActivity::class.java)
            // 2. Optionally add information to send with the intent
            registrationIntent.putExtra(ValorantDetailActivity.EXTRA_EARTHQUAKE, skinList)
            // 3. launch the new activity using the intent
            context.startActivity(registrationIntent)
            Toast.makeText(context, "You clicked this ${skinList.displayName}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount() = earthquakeList.features.size
}