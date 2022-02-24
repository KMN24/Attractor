package kg.attractor.di

import kg.attractor.data.repoImpl.MainRepoImpl
import kg.attractor.domain.repository.MainRepo
import org.koin.dsl.module

val repositoryModule = module {
    single<MainRepo> { MainRepoImpl(get()) }
}