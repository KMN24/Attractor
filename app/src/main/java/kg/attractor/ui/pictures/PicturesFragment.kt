package kg.attractor.ui.pictures

import android.view.LayoutInflater
import kg.attractor.databinding.FragmentProfileBinding
import kg.attractor.ui.utils.base.BaseVMFragment
import kg.attractor.vm.pictures.PicturesVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class PicturesFragment: BaseVMFragment<FragmentProfileBinding, PicturesVM>() {
    override val viewModel: PicturesVM by viewModel()

    override fun inflateBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater)
    }

    override fun init() {

    }
}