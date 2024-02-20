package com.example.valorantapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ValorantAdapter(private var skinList: WeaponSkinData) : RecyclerView.Adapter<ValorantAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val skinName: TextView
        val skinIcon: ImageView
        val layout: ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View
            skinName = view.findViewById(R.id.textView_itemValorantList_name)
            skinIcon = view.findViewById(R.id.imageView_itemValorantList_icon)
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
        when {
            skinList.contentTier <= 2.5 -> {
                holder.textViewMagnitude.setTextColor(context.resources.getColor(R.color.blue, context.theme))
                holder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
            }
            earthquake.properties.mag > 2.5 && earthquake.properties.mag <= 4.5 -> {
                holder.textViewMagnitude.setTextColor(context.resources.getColor(R.color.orange, context.theme))
                holder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
            }
            earthquake.properties.mag > 4.5 && earthquake.properties.mag <= 6.5 -> {
                holder.textViewMagnitude.setTextColor(context.resources.getColor(R.color.red, context.theme))
                holder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_flag_24,0,0,0)
            }
            earthquake.properties.mag > 6.5 -> {
                holder.textViewMagnitude.setTextColor(context.resources.getColor(R.color.purple, context.theme))
                holder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_flag_circle_24,0,0,0)
            }
        }
    }

    override fun getItemCount() = earthquakeList.features.size
}