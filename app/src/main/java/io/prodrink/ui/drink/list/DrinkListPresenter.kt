package io.prodrink.ui.drink.list

import android.os.Bundle
import io.prodrink.data.models.Drink
import io.prodrink.ui.base.presenter.BasePresenter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class DrinkListPresenter(private val categoryId: String) : BasePresenter<DrinkListController>() {
    private var drinkItems: List<Drink> = emptyList()

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)

        val items = ArrayList<Drink>().apply {
            for (i in 1..40) {
                add(Drink(i.toString(),
                        "Test $i",
                        "Test description $i (category: $categoryId)",
                        "http://lorempixel.com/200/200/food/${i % 7}"))
            }
        }

        Observable.fromCallable({ items })
                .doOnNext { drinkItems = it }
                .map { it.map(::DrinkListItem) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeLatestCache(DrinkListController::setDrinkItems)
    }
}