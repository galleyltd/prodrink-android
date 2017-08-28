package io.prodrink.ui.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import io.prodrink.shared.App
import io.prodrink.shared.ApplicationComponent

abstract class BaseActivity: AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        injectDependencies(App.graph)
    }

    abstract fun injectDependencies(graph: ApplicationComponent)
}