package io.prodrink.ui.category

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.jakewharton.rxbinding2.view.clicks
import io.prodrink.R
import io.prodrink.ui.base.controller.NucleusController
import kotlinx.android.synthetic.main.categories_controller.view.*
import io.prodrink.ui.barcode.BarcodeCaptureActivity

class CategoryController : NucleusController<CategoryPresenter>() {

    override fun createPresenter() = CategoryPresenter()

    override fun getTitle(): String? {
        return "Categories"
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.categories_controller, container, false)
    }

    override fun onViewCreated(view: View, savedViewState: Bundle?) {
        super.onViewCreated(view, savedViewState)

        with(view) {
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.setHasFixedSize(true)

            fab.clicks().subscribe({
                val intent = Intent(context, BarcodeCaptureActivity::class.java).apply {
                    putExtra(BarcodeCaptureActivity.AutoFocus, true)
                }
                startActivity(intent)
            })
        }
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
    }
}