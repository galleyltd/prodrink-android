package io.prodrink.ui.drink.list

import android.view.View
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import io.prodrink.R
import io.prodrink.data.models.Drink

class DrinkListItem(private val drink: Drink) : AbstractFlexibleItem<DrinkListHolder>() {
    override fun createViewHolder(view: View?,
                                  adapter: FlexibleAdapter<out IFlexible<*>>?): DrinkListHolder {
        return DrinkListHolder(view!!, adapter!!)
    }

    override fun getLayoutRes(): Int = R.layout.drink_list_item

    override fun bindViewHolder(adapter: FlexibleAdapter<*>,
                                holder: DrinkListHolder,
                                position: Int,
                                payloads: List<Any?>?) {

        holder.onSetValues(drink)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is DrinkListItem) {
            return drink.id == other.drink.id
        }
        return false
    }

    override fun hashCode(): Int = drink.id.hashCode()
}