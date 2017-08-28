package io.prodrink.ui.main

import io.prodrink.data.remote.ProDrinkApiService
import io.prodrink.ui.base.RxViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val apiService: ProDrinkApiService
) : RxViewModel() {

    private var networkRequest: Disposable = Disposables.disposed()

    private var loadingState: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)
    private val fetchErrors: PublishSubject<Throwable> = PublishSubject.create()
    private val networkErrors: PublishSubject<Throwable> = PublishSubject.create()

    fun fetchErrors(): Observable<Throwable> = fetchErrors.hide()

    fun networkErrors(): Observable<Throwable> = networkErrors.hide()

    fun loadingState(): Observable<Boolean> = loadingState.hide()

}