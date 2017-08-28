package io.prodrink.shared

import dagger.Component
import io.prodrink.data.remote.ApiModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ApiModule::class
))
interface ApplicationComponent {

    // Injectors
    fun injectTo(app: App)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
//    fun plus(module: ListModule): ListComponent
//    fun plus(module: DetailModule): DetailComponent
}