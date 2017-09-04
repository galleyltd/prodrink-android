package io.prodrink

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.squareup.leakcanary.LeakCanary
import io.fabric.sdk.android.Fabric

class App : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        bind<Context>() with instance(this@App)
//        import(NetworkModule.module)
//        import(PresentationModule.module)
    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
          // This process is dedicated to LeakCanary for heap analysis.
          // You should not init your app in this process.
          return
        }
        LeakCanary.install(this)

        @Suppress("ConstantConditionIf")
        if (BuildConfig.USE_CRASHLYTICS) {
            Fabric.with(this, Crashlytics())
        }
    }
}