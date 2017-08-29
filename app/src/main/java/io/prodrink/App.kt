package io.prodrink

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance


class App : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        bind<Context>() with instance(this@App)
//        import(NetworkModule.module)
//        import(PresentationModule.module)
    }
}