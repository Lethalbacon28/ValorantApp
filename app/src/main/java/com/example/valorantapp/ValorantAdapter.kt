package com.example.valorantapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ValorantAdapter(var dataSkins: WeaponSkinData):
    RecyclerView.Adapter<ValorantAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDisplayName: TextView
        val imageViewContentTier: ImageView
        val imageViewDisplayIcon: ImageView
        val layout: ConstraintLayout

        init {
            textViewDisplayName = view.findViewById(R.id.textView_item_displayName)
            imageViewContentTier = view.findViewById(R.id.imageView_item_contentTier)
            imageViewDisplayIcon = view.findViewById(R.id.imageView_item_displayIcon)
            layout = view.findViewById(R.id.layout_valorant)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_valorant, viewGroup, false)

        return ViewHolder(view)

    }    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val valorant = dataSkins.features[position]
        val context = viewHolder.layout.context
        viewHolder.textViewMagnitude.text = String.format("%.1f", earthquake.properties.mag)
        viewHolder.textViewLocation.text = earthquake.properties.place
        viewHolder.textViewTime.text = Date(earthquake.properties.time).toString()
        // click listener here later


        viewHolder.layout.setOnClickListener {
            // Toast.makeText(context, "You clicked on ${hero.name}", Toast.LENGTH_SHORT).show()

            val registrationIntent = Intent(context, EarthquakeMapActivity::class.java)
            registrationIntent.putExtra(EarthquakeMapActivity.EXTRA_EARTHQUAKE, earthquake)
//            val intent = Intent(context, HeroesDetailActivity::class.java)
//            intent.putExtra("name", hero.name)
//            intent.putExtra("description", hero.description)
//            intent.putExtra("ranking", hero.ranking)
//            intent.putExtra("superpower", hero.superpower)
            //          context.startActivity(intent)
            context.startActivity(registrationIntent)
        }

    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val earthquake = earthquakes.features[position]
        val context = viewHolder.layout.context
        viewHolder.textViewMagnitude.text = String.format("%.1f", earthquake.properties.mag)
        viewHolder.textViewLocation.text = earthquake.properties.place
        viewHolder.textViewTime.text = Date(earthquake.properties.time).toString()
        // click listener here later

        when {
            // small
            earthquake.properties.mag >= 1 && earthquake.properties.mag < 2.5 -> {
                viewHolder.textViewMagnitude.setTextColor(context.resources.getColor(R.color.blue))
                viewHolder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
            }
            earthquake.properties.mag >= 2.5 && earthquake.properties.mag < 4.5 ->{
                viewHolder.textViewMagnitude.setTextColor(context.resources.getColor(com.example.earthquake.R.color.orange))
                viewHolder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
            }
            earthquake.properties.mag >= 4.5 && earthquake.properties.mag < 6.5 ->{
                viewHolder.textViewMagnitude.setTextColor(context.resources.getColor(com.example.earthquake.R.color.burgundy))
                viewHolder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.baseline_error_outline_24, 0, 0, 0)
            }
            earthquake.properties.mag >= 6.5->{
                viewHolder.textViewMagnitude.setTextColor(context.resources.getColor(com.example.earthquake.R.color.purple))
                viewHolder.textViewMagnitude.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.baseline_error_24, 0, 0, 0)
            }



        }




        viewHolder.layout.setOnClickListener {
            // Toast.makeText(context, "You clicked on ${hero.name}", Toast.LENGTH_SHORT).show()

            val registrationIntent = Intent(context, EarthquakeMapActivity::class.java)
            registrationIntent.putExtra(EarthquakeMapActivity.EXTRA_EARTHQUAKE, earthquake)
//            val intent = Intent(context, HeroesDetailActivity::class.java)
//            intent.putExtra("name", hero.name)
//            intent.putExtra("description", hero.description)
//            intent.putExtra("ranking", hero.ranking)
//            intent.putExtra("superpower", hero.superpower)
            //          context.startActivity(intent)
            context.startActivity(registrationIntent)
        }

    }
}