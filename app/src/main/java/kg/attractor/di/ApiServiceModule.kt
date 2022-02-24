package kg.attractor.di

import kg.attractor.data.network.service.MainService
import kg.attractor.data.utils.provideNetworkService
import org.koin.dsl.module

val apiServiceModule = module {
    factory { provideNetworkService(MainService::class.java) }
}