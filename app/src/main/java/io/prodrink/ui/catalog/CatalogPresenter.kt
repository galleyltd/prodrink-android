package io.prodrink.ui.catalog

import android.os.Bundle
import io.prodrink.data.models.Category
import io.prodrink.ui.base.presenter.BasePresenter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class CatalogPresenter : BasePresenter<CatalogController>() {

    private var categories: List<Category> = emptyList()

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)

        val items = ArrayList<Category>().apply {
            for (i in 1..20) {
                add(Category(i.toString(), "Test $i", "http://lorempixel.com/400/400/food/${i % 7}"))
            }
        }

        Observable.fromCallable({ items })
                .doOnNext { categories = it }
                .map { it.map(::CatalogItem) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeLatestCache(CatalogController::setCategories)
    }
}