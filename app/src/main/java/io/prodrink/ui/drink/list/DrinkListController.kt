package io.prodrink.ui.drink.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import io.prodrink.R
import io.prodrink.ui.base.controller.NucleusController
import kotlinx.android.synthetic.main.catalog_controller.view.*

class DrinkListController(private val categoryId: String) :
        NucleusController<DrinkListPresenter>(),
        FlexibleAdapter.OnItemClickListener {

    companion object {
        const val CATEGORY_EXTRA = "category"
    }

    init {
        Bundle().apply {
            putString(CATEGORY_EXTRA, categoryId)
        }
    }

    @Suppress("unused")
    constructor(bundle: Bundle) : this(bundle.getString(CATEGORY_EXTRA))

    private var adapter: FlexibleAdapter<IFlexible<*>>? = null

    override fun getTitle(): String? = "Drinks ($categoryId)"

    override fun onItemClick(position: Int): Boolean {
        return false
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.drink_list_controller, container, false)
    }

    override fun onViewCreated(view: View, savedViewState: Bundle?) {
        super.onViewCreated(view, savedViewState)

        adapter = FlexibleAdapter(null, this)

        with(view) {
            recycler.setHasFixedSize(true)
            recycler.adapter = adapter
        }
    }

    override fun createPresenter(): DrinkListPresenter = DrinkListPresenter(categoryId)

    fun setDrinkItems(categories: List<DrinkListItem>) {
        adapter?.updateDataSet(categories)
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        adapter = null
    }
}