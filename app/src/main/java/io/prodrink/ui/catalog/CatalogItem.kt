package io.prodrink.ui.catalog

import android.view.View
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import io.prodrink.R
import io.prodrink.data.models.Category

class CatalogItem(val category: Category) : AbstractFlexibleItem<CatalogHolder>() {
    override fun createViewHolder(view: View?,
                                  adapter: FlexibleAdapter<out IFlexible<*>>?): CatalogHolder {
        return CatalogHolder(view!!, adapter!!)
    }

    override fun getLayoutRes(): Int = R.layout.catalog_item

    override fun bindViewHolder(adapter: FlexibleAdapter<*>,
                                holder: CatalogHolder,
                                position: Int,
                                payloads: List<Any?>?) {

        holder.onSetValues(category)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is CatalogItem) {
            return category.id == other.category.id
        }
        return false
    }

    override fun hashCode(): Int = category.id.hashCode()
}
