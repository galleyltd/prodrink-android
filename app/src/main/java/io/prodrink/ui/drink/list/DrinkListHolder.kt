package io.prodrink.ui.drink.list

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.viewholders.FlexibleViewHolder
import io.prodrink.R
import io.prodrink.data.models.Drink
import kotlinx.android.synthetic.main.drink_list_item.view.*

class DrinkListHolder(private val view: View, adapter: FlexibleAdapter<*>) :
        FlexibleViewHolder(view, adapter) {

    fun onSetValues(drink: Drink) {
        with (view) {
            title.text = drink.title
            description.text = drink.description
        }

        setImage(drink)
    }

    private fun setImage(drink: Drink) {
        Glide.with(view.context).clear(view.thumbnail)
        if (!drink.thumbnail_url.isEmpty()) {
            Glide.with(view.context)
                    .load(drink.thumbnail_url)
                    .apply(RequestOptions.centerCropTransform()
                            .placeholder(R.drawable.ic_broken_image_grey_24dp))
                    .into(view.thumbnail)
        }
    }
}