package io.prodrink.ui.catalog

import android.content.Intent
import android.os.Bundle
import android.view.*
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.jakewharton.rxbinding2.view.clicks
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import eu.davidea.flexibleadapter.items.IFlexible
import io.prodrink.R
import io.prodrink.ui.base.controller.NucleusController
import kotlinx.android.synthetic.main.catalog_controller.view.*
import io.prodrink.ui.barcode.BarcodeCaptureActivity
import io.prodrink.ui.drink.list.DrinkListController

class CatalogController :
        NucleusController<CatalogPresenter>(),
        FlexibleAdapter.OnItemClickListener {

    private var adapter: FlexibleAdapter<IFlexible<*>>? = null

    override fun createPresenter() = CatalogPresenter()

    override fun getTitle(): String? = "Catalog"

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.catalog_controller, container, false)
    }

    override fun onViewCreated(view: View, savedViewState: Bundle?) {
        super.onViewCreated(view, savedViewState)

        adapter = FlexibleAdapter(null, this)

        with(view) {
            recycler.setHasFixedSize(true)
            recycler.adapter = adapter
            recycler.addItemDecoration(FlexibleItemDecoration(context)
                    .withOffset(4))

            fab.clicks().subscribe({
                val intent = Intent(context, BarcodeCaptureActivity::class.java).apply {
                    putExtra(BarcodeCaptureActivity.AutoFocus, true)
                }
                startActivity(intent)
            })
        }
    }

    fun setCategories(categories: List<CatalogItem>) {
        adapter?.updateDataSet(categories)
    }

    override fun onItemClick(position: Int): Boolean {
        val item = adapter?.getItem(position) as? CatalogItem ?: return false
        router.pushController(RouterTransaction.with(DrinkListController(item.category.id))
                .pushChangeHandler(FadeChangeHandler())
                .popChangeHandler(FadeChangeHandler()))

        return false
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        adapter = null
    }
}