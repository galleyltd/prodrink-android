package io.prodrink.ui.catalog

import android.content.Intent
import android.os.Bundle
import android.view.*
import com.jakewharton.rxbinding2.view.clicks
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import io.prodrink.R
import io.prodrink.ui.base.controller.NucleusController
import kotlinx.android.synthetic.main.catalog_controller.view.*
import io.prodrink.ui.barcode.BarcodeCaptureActivity

class CatalogController :
        NucleusController<CatalogPresenter>(),
        FlexibleAdapter.OnItemClickListener {

    private var adapter: FlexibleAdapter<IFlexible<*>>? = null

    override fun createPresenter() = CatalogPresenter()

    override fun getTitle(): String? {
        return "Categories"
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.catalog_controller, container, false)
    }

    override fun onViewCreated(view: View, savedViewState: Bundle?) {
        super.onViewCreated(view, savedViewState)

        adapter = FlexibleAdapter(null, this)

        with(view) {
            recycler.setHasFixedSize(true)
            recycler.adapter = adapter

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
        return true
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        adapter = null
    }
}