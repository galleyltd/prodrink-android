package io.prodrink.ui.category

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import io.prodrink.R
import io.prodrink.ui.base.controller.NucleusController
import kotlinx.android.synthetic.main.categories_controller.view.*

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
        }
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
    }
}