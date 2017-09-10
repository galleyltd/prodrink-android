package io.prodrink.ui.catalog

import android.view.View
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.viewholders.FlexibleViewHolder
import io.prodrink.data.models.Category

abstract class CatalogHolder(view: View, adapter: FlexibleAdapter<*>) :
        FlexibleViewHolder(view, adapter) {

    abstract fun onSetValues(category: Category)

    abstract fun setImage(category: Category)
}