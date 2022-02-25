package kg.attractor

import android.app.Application
import kg.attractor.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(
                apiServiceModule,
                useCaseModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}