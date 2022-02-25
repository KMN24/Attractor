package kg.attractor.di


import kg.attractor.vm.pictures.PicturesVM
import kg.attractor.vm.profile.ProfileVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { ProfileVM(get()) }
    viewModel { PicturesVM() }
}