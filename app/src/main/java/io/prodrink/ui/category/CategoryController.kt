package io.prodrink.ui.category

import android.os.Bundle
import android.support.v7.view.ActionMode
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import io.prodrink.R
import io.prodrink.ui.base.controller.NucleusController
import kotlinx.android.synthetic.main.categories_controller.view.*

class CategoryController : NucleusController<CategoryPresenter>(),
        ActionMode.Callback {

    private var actionMode: ActionMode? = null

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
        actionMode = null
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        return true
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        actionMode = null
    }
}