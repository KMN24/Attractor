package kg.attractor.di

import kg.attractor.domain.use_cases.GetUserUC
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetUserUC(get()) }
}